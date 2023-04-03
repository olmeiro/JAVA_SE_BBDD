package org.olmeiro.red_social.model;

public class Message {

    private int messageId;
    private String message;
    private String date;
    private String fullName;

    //foreing attributes:
    private int userId;

    public Message() {}

    public Message(int messageId, int userId) {
        this.messageId = messageId;
        this.userId = userId;
    }

    //Create Message
    public Message(String message, int userId) {
        this.message = message;
        this.userId = userId;
    }

    //list messages:
    public Message(int messageId, String message, String date, String fullName) {
        this.messageId = messageId;
        this.message = message;
        this.date = date;
        this.fullName = fullName;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
