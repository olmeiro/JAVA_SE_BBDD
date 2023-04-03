package org.olmeiro.red_social;

import org.olmeiro.red_social.model.User;
import org.olmeiro.red_social.service.MessageService;
import org.olmeiro.red_social.service.UserService;

import java.util.Scanner;

public class Main {

    static String mainMenuMessage = ("=================== \n"
            + "\n Mini social network \n"
            + "1. Register \n"
            + "2. Login \n"
            + "3. Logout \n");

    public static void main(String[] args) {
        //create an instance of Scanner class to read user input
        Scanner sc = new Scanner(System.in);
        mainMenu(sc);
        sc.close();
    }

    public static void mainMenu(Scanner sc){
        int option = 0;

        //First Menu:
        do{
            System.out.println(mainMenuMessage);
            //Read user input:
            option = sc.nextInt();

            switch (option){
                case 1:
                    UserService.createUser(sc);
                    break;
                case 2:
                    User result = UserService.login(sc);
                    if(result.getUserId() > 0){
                        MenuSession.menuSession(result, sc);
                    }
                    break;
                default:
                    break;
            }
        }while(option != 3);
    }
}