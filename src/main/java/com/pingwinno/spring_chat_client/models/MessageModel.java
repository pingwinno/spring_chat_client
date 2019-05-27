package com.pingwinno.spring_chat_client.models;

import java.util.Date;

public class MessageModel {
    private Date time;
    private String user;
    private String message;

    public MessageModel() {
    }

    public MessageModel(Date time, String user, String message) {
        this.time = time;
        this.user = user;
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
