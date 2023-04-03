package org.olmeiro.red_social.service;

import org.olmeiro.red_social.dao.MessageDAO;
import org.olmeiro.red_social.model.Message;
import org.olmeiro.red_social.model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class MessageService {

    static String messageTextMessage = "Write your message, max 280 characters";
    static String messageIdToBeDeletedMessage = "Select the message id you want to delete.";
    public static void createMessage(User user, Scanner sc) {
        System.out.println(messageTextMessage);
        String messageText = sc.next();
        Message message = new Message(messageText, user.getUserId());
        MessageDAO.createMessageDB(message);
    }

    public static void listMessage(){
        MessageDAO.listMessageDB();
    }

    public static void deleteMessage(User user, Scanner sc){
        System.out.println(messageIdToBeDeletedMessage);
        int messageId = sc.nextInt();
        Message message = new Message(messageId, user.getUserId());
        try {
            MessageDAO.deleteMessageDB(message);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void editMessage(User user, Scanner sc){
        System.out.println("Write your updated message");
        String messageUpdate = sc.nextLine();

        System.out.println("Choose id message to be update it.");
        int id_message = sc.nextInt();

        Message dataUpdate = new Message();
        dataUpdate.setMessageId(id_message);
        dataUpdate.setMessage(messageUpdate);
        dataUpdate.setUserId(user.getUserId());
        MessageDAO.updateMessageDB(dataUpdate);
    }
}
