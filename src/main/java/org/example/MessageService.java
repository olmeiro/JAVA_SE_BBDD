package org.example;

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
        registry.setAuthor_menssage(name);

        //send to DAO:
        MessageDAO.createMessageDB(registry);
    }

    public static void listMessage(){

    }

    public static void deleteMessage(){

    }

    public static void editMessage(){

    }
}
