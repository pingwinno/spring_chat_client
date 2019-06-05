package com.pingwinno.spring_chat_client;

import com.pingwinno.spring_chat_client.models.MessageModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.LinkedList;

@Service("sessionHandler")
public class ClientMessageHandler extends StompSessionHandlerAdapter {
    private static StompSession session;
    private Logger logger = LogManager.getLogger(ClientMessageHandler.class);
    private MessageHandler handler;


    public static void sendMessage(MessageModel messageModel) {
        session.send("/usersMessage",messageModel);
    }

    @Autowired
    public void setMessageHandler(MessageHandler handler) {
        this.handler = handler;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.error("Subscribed");
        this.session = session;
        session.subscribe("/topic/broadcast", this);
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        logger.debug("Message received");
        MessageModel[] messageModels = (MessageModel[]) payload;
        for (MessageModel messageModel : messageModels) {
            handler.handle(messageModel);

        }
    }


    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        //  super.handleException(session, command, headers, payload, exception);
        logger.error("Receive error ", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        LinkedList<MessageModel> aClass = new LinkedList<>();
        return MessageModel[].class;
    }


}
