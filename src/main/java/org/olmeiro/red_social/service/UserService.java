package org.olmeiro.red_social.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.olmeiro.red_social.dao.UserDAO;
import org.olmeiro.red_social.model.User;

import java.util.Scanner;

public class UserService {
    static String fullNameMessage = "Enter your full name.";
    static String emailMessage = "Enter your email.";
    static String passwordMessage = "Enter your password";

    public static void createUser(Scanner sc){
        sc.nextLine();
        System.out.println(fullNameMessage);
        String fullName = sc.nextLine();

        System.out.println(emailMessage);
        String email = sc.nextLine();

        System.out.println(passwordMessage);
        String password = sc.nextLine();

        password = getMd5Hash(password);

        User newUser = new User(0, email, password, fullName);
        UserDAO.createUserOnDB(newUser);

    }

    public static void listUsers() {
        UserDAO.listUsersDB();
    }

    public static void editUser(User user, Scanner sc){
        sc.nextLine();
        System.out.println(fullNameMessage);
        String fullName = sc.nextLine();
        System.out.println(emailMessage);
        String email = sc.nextLine();
        System.out.println(passwordMessage);
        String password = sc.nextLine();

        String passwordHashed = getMd5Hash(password);
        User updatedUser = new User(user.getUserId(), email, passwordHashed, fullName);
        UserDAO.editUserOnDB(updatedUser);
    }

    public static User login(Scanner sc){
        //create an instance of Scanner class to read user input
        System.out.println(emailMessage);
        String email = sc.next();
        System.out.println(passwordMessage);
        String password = sc.next();

        String passwordHashed = getMd5Hash(password);

        User login = new User(email, passwordHashed);
        User result = UserDAO.loginDb(login);
        return result;
    }
    private static String getMd5Hash(String password) {

        return DigestUtils.md5Hex(password);
//        return password;
    }
}
