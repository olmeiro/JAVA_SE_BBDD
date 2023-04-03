package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class MessageService {
    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your message");
        String message = sc.nextLine();

        System.out.println("Your name please:");
        String name = sc.nextLine();

        Message registry = new Message();
        registry.setMessage(message);
        registry.setAuthor_message(name);

        //send to DAO:
        MessageDAO.createMessageDB(registry);
    }

    public static void listMessage(){
        MessageDAO.readMessageDB();
    }

    public static void deleteMessage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose id message to delete it.");
        int id_message = sc.nextInt();
        try {
            MessageDAO.deleteMessageDB(id_message);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void editMessage(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Write your updated message");
        String messageUpdate = sc.nextLine();

        System.out.println("Choose id message to be update it.");
        int id_message = sc.nextInt();

        Message dataUpdate = new Message();
        dataUpdate.setId_message(id_message);
        dataUpdate.setMessage(messageUpdate);
        MessageDAO.updateMessageDB(dataUpdate);
    }
}
