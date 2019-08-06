package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserController {

    private static String currentUser;

    private List<User> users = new ArrayList<>();

    public Boolean login() {
        Scanner scan = new Scanner(System.in);
        if (currentUser == null) {
            System.out.println("Please enter your user id");
            String userId = scan.next();
            System.out.println("Please enter your password");
            String password = scan.next();
            Boolean isCorrect = checkAccount(userId, password);
            if (isCorrect) {
                currentUser = userId;
                System.out.println("Your account login successfully!");
                return true;
            }
            currentUser = null;
            System.out.println("User id or password not correct!");
            return false;
        }
        return true;
    }

    public void logout(){
        currentUser = null;
    }

    private Boolean checkAccount(String id, String password) {
        User user = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
        if (user == null) return false;
        return user.getPassword().equals(password);
    }

    public void showUserInformation() {
        System.out.printf(
                "%-30s%-30s%-30s%-30s%n",
                "-- Id --",
                "-- Name --",
                "-- Phone --",
                "-- Email --"
        );
        User user = users.stream().filter(u -> u.getId().equals(currentUser)).findFirst().orElse(null);
        if(user != null){
            System.out.printf(
                    "%-30s%-30s%-30s%-30s%n",
                    user.getId(),
                    user.getName(),
                    user.getPhone(),
                    user.getEmail()
            );
        }else {
            System.out.println("No user information");
        }
    }


    public void addUser(User user) {
        users.add(user);
    }

    public static String getCurrentUser() {
        return currentUser;
    }


}
