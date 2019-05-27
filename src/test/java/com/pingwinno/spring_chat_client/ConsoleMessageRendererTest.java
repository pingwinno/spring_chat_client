package com.pingwinno.spring_chat_client;

import com.pingwinno.spring_chat_client.models.MessageModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.*;

public class ConsoleMessageRendererTest {
    MessageModel messageModel;
    @Before
            public void init() {
         messageModel = new MessageModel();
        messageModel.setTime(Date.from(Instant.now()));
        messageModel.setUser("Server");
        messageModel.setMessage("Hello");
    }

    @Test
    public void handle() {
        MessageHandler messageHandler = new ConsoleMessageRenderer();
        messageHandler.handle(messageModel);
    }
}