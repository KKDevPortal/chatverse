package com.kkdevportal.chatverse.controller;

import com.kkdevportal.chatverse.model.ChatMessage;
import com.kkdevportal.chatverse.service.ChatverseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatverseController {
    private final ChatverseService chatService;

    /**
     * Send message to a chat room
     */
    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(
            @RequestParam String roomId,
            @RequestParam String sender,
            @RequestParam String message) {

        chatService.sendMessage(roomId, sender, message);
        return ResponseEntity.ok().build();
    }

    /**
     * Get full chat history
     */
    @GetMapping("/history/{roomId}")
    public ResponseEntity<List<ChatMessage>> getHistory(
            @PathVariable String roomId) {

        return ResponseEntity.ok(chatService.getChatHistory(roomId));
    }


}
