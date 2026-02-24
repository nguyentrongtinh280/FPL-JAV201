package servlet;

import entity.Message;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(
        value = "/json/chat/{username}",
        encoders = MessageEncoder.class,
        decoders = MessageDecoder.class
)
public class ChatServerEndPoint {
    private static Map<String, Session> sessions = new HashMap<>();

    private void broadcast(String message) {
        sessions.forEach((username, session) -> {
            try {
                session.getBasicRemote().sendObject(message);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        });
    }

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        if (sessions.containsKey(username)) {
            throw new RuntimeException("Username is already exists");
        } else {
            session.getUserProperties().put("username", username);
            sessions.put(username, session);
            Message message = new Message("Joined the chat", 0, username, sessions.size());
            this.broadcast(String.valueOf(message));
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            throw new RuntimeException("Unable to close session");
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        this.broadcast(message);
    }

    @OnClose
    public void onClose(Session session) {
        String username = (String) session.getUserProperties().get("username");
        sessions.remove(username);
        Message message = new Message("left the chat", 1, username, sessions.size());
        this.broadcast(String.valueOf(message));
    }
}
