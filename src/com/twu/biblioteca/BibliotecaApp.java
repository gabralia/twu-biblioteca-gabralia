package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;
import com.twu.biblioteca.controller.UserController;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;

public class BibliotecaApp {

    public static void main(String[] args) {

        BookController bookController = new BookController();
        bookController.addBook(new Book("1","The Secret Garden","Frances Hodgson Burnett","2014",28.0));
        Book b = new Book("2","A Briefer History of Time","Stephen Hawking","2005",38.0);
        b.setAvailable(false);
        b.setUserId("2");
        bookController.addBook(b);

        UserController userController = new UserController();
        userController.addUser(new User("1","Jinnew Chyi","123","13389773421","gabralia@gmail.com"));
        userController.addUser(new User("2","Little Voice","123","13389773421","LittleVoice@gmail.com"));

        WelcomeMenu welcomeMenu = new WelcomeMenu(bookController,userController);
        welcomeMenu.welcome();
        welcomeMenu.menu();
    }
}
