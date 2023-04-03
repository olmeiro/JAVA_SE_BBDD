package org.olmeiro.red_social;

import org.olmeiro.red_social.model.User;
import org.olmeiro.red_social.service.MessageService;
import org.olmeiro.red_social.service.UserService;

import java.util.Scanner;

public class MenuSession {
    public static void menuSession(User user, Scanner sc){
        int option = 0;
        String sessionMenuMessage = ("=================== \n"
                + "\n social Net, Hello "+user.getFullName()+" \n"
                + "1. Write message \n"
                + "2. Read messages \n"
                + "3. Delete messages \n"
                + "4. Update profile \n"
                + "5. See users \n"
                + "6. Logout \n");

        //menu when session starts
        do{
            System.out.println(sessionMenuMessage);
            //Read user input
            option = sc.nextInt();

            switch (option){
                case 1:
                    MessageService.createMessage(user, sc);
                    break;
                case 2:
                    MessageService.listMessage();
                    break;
                case 3:
                    MessageService.deleteMessage(user, sc);
                    break;
                case 4:
                    UserService.editUser(user, sc);
                    break;
                case 5:
                    UserService.listUsers();
                    break;
                default:
                    break;
            }
        }while(option != 6);
    }
}
