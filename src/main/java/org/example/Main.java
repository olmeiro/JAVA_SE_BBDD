package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("==================================");
            System.out.println("Messages App");
            System.out.println("1. Create Message");
            System.out.println("2. List Messages");
            System.out.println("3. Edit Message");
            System.out.println("4. Delete Message");
            System.out.println("5. Logout");

            //read option selected
            option = sc.nextInt();

            switch (option) {
                case 1:
                    try {
                        MessageService.createMessage();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    MessageService.deleteMessage();
                    break;
                case 4:
                    MessageService.editMessage();
                    break;
                default:
                    break;
            }
        } while (option != 5);

    }
}