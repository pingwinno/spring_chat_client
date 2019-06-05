package com.pingwinno.spring_chat_client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Configuration
public class Config {
    @Bean
    WebSocketStompClient stompClient(){
       return new WebSocketStompClient( new StandardWebSocketClient());
    }
    @Bean
    MessageConverter messageConverter(){
        return new MappingJackson2MessageConverter();
    }



}
