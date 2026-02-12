Here is a simpler version of your `README.md`:

------

# ChatVerse

ChatVerse is a simple chatting application built using Spring Boot, Redis, and MongoDB.

Users can communicate with each other through chat rooms.

## Features

- Create a chat room
- Join an existing chat room
- Send and receive messages inside a chat room
- Store chat history in MongoDB
- Use Redis for fast message handling

## How It Works

1. A user creates a chat room.
2. Another user joins the same chat room.
3. Both users can send messages and communicate within that room.
4. Messages are stored in MongoDB.

## Tech Stack

- Spring Boot
- MongoDB
- Redis
- Maven

## Requirements

- Java 17 or higher
- MongoDB running locally
- Redis running locally

## Configuration

Example `application.yml`:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/chatverse
  redis:
    host: localhost
    port: 6379
```

## Run the Application

Start MongoDB and Redis first.

Then run:

```
mvn spring-boot:run
```

Application runs on:

```
http://localhost:8080
```

## Future Improvements

- WebSocket support for real-time communication
- Authentication and authorization
- Private messaging
- Docker support

------