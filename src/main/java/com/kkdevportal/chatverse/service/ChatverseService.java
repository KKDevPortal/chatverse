package com.kkdevportal.chatverse.service;

import com.kkdevportal.chatverse.model.ChatMessage;
import com.kkdevportal.chatverse.repository.ChatverseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChatverseService {
    private final ChatverseRepository repository;
    private final RedisTemplate<String, Object> redisTemplate;


    /**
     * Save message to MongoDB (permanent storage)
     * AND publish to Redis Stream (real-time)
     */
    public void sendMessage(String roomId, String sender, String content) {

        // 1️⃣ Save to MongoDB
        ChatMessage message = new ChatMessage();
        message.setRoomId(roomId);
        message.setSender(sender);
        message.setContent(content);
        message.setTimestamp(Instant.now());

        repository.save(message);

        // 2️⃣ Publish to Redis Stream
        String streamKey = "chat:room:" + roomId;

        Map<String, String> body = new HashMap<>();
        body.put("sender", sender);
        body.put("content", content);
        body.put("timestamp", message.getTimestamp().toString());

        redisTemplate.opsForStream()
                .add(StreamRecords.mapBacked(body).withStreamKey(streamKey));
    }

    /**
     * Fetch chat history from MongoDB
     */
    public List<ChatMessage> getChatHistory(String roomId) {
        return repository.findByRoomIdOrderByTimestampAsc(roomId);
    }


}
