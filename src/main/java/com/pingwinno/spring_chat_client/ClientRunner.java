package com.pingwinno.spring_chat_client;

import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Component
public class ClientRunner {
    private static WebSocketStompClient stompClient;
    private static StompSessionHandler sessionHandler;
    String URL = "ws://localhost:8080/chat";

    public ClientRunner(WebSocketStompClient stompClient, StompSessionHandler sessionHandler, MessageConverter messageConverter) {
        ClientRunner.stompClient = stompClient;
        ClientRunner.sessionHandler = sessionHandler;
        stompClient.setMessageConverter(messageConverter);
        stompClient.connect(URL, sessionHandler);
    }
}
