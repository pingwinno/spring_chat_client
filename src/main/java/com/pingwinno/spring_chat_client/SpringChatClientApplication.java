package com.pingwinno.spring_chat_client;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

@SpringBootApplication
@Configuration
public class SpringChatClientApplication  implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringChatClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String URL = "ws://localhost:8080/chat";
        ClientRunner.connect(URL);
        System.out.println("ksfjnsejignf");
        new Scanner(System.in).nextLine();
    }
}
