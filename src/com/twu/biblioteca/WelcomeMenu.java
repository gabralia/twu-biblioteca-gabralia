package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;

import java.util.Scanner;

public class WelcomeMenu {

    private Scanner scan = new Scanner(System.in);

    private BookController bookController;

    public WelcomeMenu(BookController bookController){
        this.bookController = bookController;
    }

    public void welcome(){
        System.out.println("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!");
    }

    public void menu(){
        System.out.println("");
        System.out.println("Menu");
        System.out.println("1 to view the list of books");
        System.out.println("2 to checkout a book");
        System.out.println("3 to return a book");
        System.out.println("q to quit the website");
        String option = scan.next();
        handleMenu(option);
        menu();
    }

    private void handleMenu(String option){
        String id;
        switch(option){
            case "1":
                bookController.showBookList();
                break;
            case "2":
                System.out.println("please enter the Id of the book you want to checkout.");
                id = scan.next();
                bookController.checkoutBook(id);
                break;
            case "3":
                System.out.println("please enter the Id of the book you want to return.");
                id = scan.next();
                bookController.returnBook(id);
                break;
            case "q":
                System.out.println("Bye! See you next time!");
                System.exit(0);
            default:
                System.out.println("Invalid option!");
                break;
        }
    }
}
