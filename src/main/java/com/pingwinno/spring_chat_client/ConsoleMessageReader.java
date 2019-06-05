package com.pingwinno.spring_chat_client;

import com.pingwinno.spring_chat_client.models.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

@Service
public class ConsoleMessageReader {

   static private String user;



    public void handleInput(Scanner in) {
        if (user == null) {
            while (!authorize(in)) {
                System.out.println("Username is empty");
            }
        }
        readMessage(in);
    }

    private boolean authorize(Scanner in) {
        System.out.println("Enter username");
        if (in.hasNext()) {
            user = in.nextLine();
            return !user.trim().equals("");
        }
        return false;
    }

    private void readMessage(Scanner in) {
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(in.nextLine());
        messageModel.setUser(user);
        messageModel.setTime(Date.from(Instant.now()));
        ClientMessageHandler.sendMessage(messageModel);
    }
}
