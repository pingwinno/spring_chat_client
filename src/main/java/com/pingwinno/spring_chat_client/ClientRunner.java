package com.pingwinno.spring_chat_client;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.net.URL;

@Service
public class ClientRunner {
    private static WebSocketStompClient stompClient;
    private static StompSessionHandler sessionHandler;

    public ClientRunner(WebSocketStompClient stompClient, StompSessionHandler sessionHandler, MessageConverter messageConverter) {
        ClientRunner.stompClient = stompClient;
        ClientRunner.sessionHandler = sessionHandler;
        stompClient.setMessageConverter(messageConverter);
    }

    public static  void connect(String url) {
        stompClient.connect(url, sessionHandler);
    }
}
