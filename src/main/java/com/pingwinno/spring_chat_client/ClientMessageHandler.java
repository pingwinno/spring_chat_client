package com.pingwinno.spring_chat_client;

import com.pingwinno.spring_chat_client.models.MessageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service("sessionHandler")
public class ClientMessageHandler extends StompSessionHandlerAdapter {
    private Logger logger = LogManager.getLogger(ClientMessageHandler.class);

    private MessageHandler handler;

    @Autowired
    public void setMessageHandler(MessageHandler handler) {
       this.handler = handler;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.error("Subscribed");
        session.subscribe("/topic/broadcast", this);
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        logger.error("Message received");
        MessageModel messageModels = (MessageModel) payload;
        if (messageModels != null) {
            handler.handle(messageModels);
        }
      /*  LinkedList<MessageModel> messageModels = (LinkedList<MessageModel>) payload;
        for (MessageModel messageModel:messageModels) {
            handler.handle(messageModel);

        }*/
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        super.handleException(session, command, headers, payload, exception);
        logger.error("Receive error {}", payload, exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {

        return MessageModel.class;
    }


}
