package com.pingwinno.spring_chat_client;

import com.pingwinno.spring_chat_client.models.MessageModel;

public interface MessageHandler {

    void handle(MessageModel messageModel);
}
