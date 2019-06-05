package com.pingwinno.spring_chat_client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@SpringBootApplication
@Configuration
public class SpringChatClientApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringChatClientApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Thread.sleep(1000);
        ConsoleMessageReader consoleMessageReader = new ConsoleMessageReader( );
        Scanner scanner = new Scanner(System.in);
        while (true){
            consoleMessageReader.handleInput(scanner);
        }

    }
}
