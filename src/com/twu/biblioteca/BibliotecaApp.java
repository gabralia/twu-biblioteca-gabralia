package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;
import com.twu.biblioteca.model.Book;

public class BibliotecaApp {

    public static void main(String[] args) {

        BookController bookController = new BookController() ;
        bookController.addBook(new Book("1","The Secret Garden","Frances Hodgson Burnett","2014",28.0,true));
        bookController.addBook(new Book("2","A Briefer History of Time","Stephen Hawking","2005",38.0,true));
        WelcomeMenu welcomeMenu = new WelcomeMenu(bookController);
        welcomeMenu.welcome();
        welcomeMenu.menu();
    }
}
