package org.example;

public class Message {

    private int id_message;
    private String message;
    private String author_message;
    private String date_message;

    public Message() {}

    public Message(int id_message, String message, String author_message, String date_message) {
        this.id_message = id_message;
        this.message = message;
        this.author_message = author_message;
        this.date_message = date_message;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor_message() {
        return author_message;
    }

    public void setAuthor_message(String author_menssage) {
        this.author_message = author_menssage;
    }

    public String getDate_message() {
        return date_message;
    }

    public void setDate_message(String date_message) {
        this.date_message = date_message;
    }
}
