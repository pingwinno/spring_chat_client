package com.pingwinno.spring_chat_client;

import com.pingwinno.spring_chat_client.models.MessageModel;

import org.springframework.stereotype.Service;

@Service("handler")
public class ConsoleMessageRenderer implements MessageHandler {

    public ConsoleMessageRenderer() {
        System.out.println("Object created");
    }

    @Override
    public void handle(MessageModel messageModel) {
        System.out.println(messageModel.getTime().toString() + " " + messageModel.getUser() + "  " +messageModel.getMessage());
    }
}
