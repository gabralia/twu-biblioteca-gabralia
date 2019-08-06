package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class BookControllerTest {

    private Book book = new Book("1","The Secret Garden","Frances Hodgson Burnett","2014",28.0);

    private BookController bookController = new BookController();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void login() {
        ByteArrayInputStream in1 = new ByteArrayInputStream("1\n".getBytes());
        ByteArrayInputStream in2 = new ByteArrayInputStream("123\n".getBytes());
        SequenceInputStream in = new SequenceInputStream(in1,in2);
        System.setIn(in);
        UserController userController = new UserController();
        userController.addUser(
                new User("1","Jinnew Chyi","123","13389773421","gabralia@gmail.com")
        );
        userController.login();
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setIn(System.in);
        System.setOut(null);
    }

    @Before
    public void addBooks() {
        bookController.addBook(book);
    }

    @Test
    public void bookListCanBeOutput(){
        bookController.showBookList();
        assertThat(outContent.toString(), containsString(String.format(
                "%-30s%-30s%-30s%-30s%-30s%-30s%n",
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublishYear(),
                book.getPrice(),
                book.getAvailable()?"yes":"no"
        )));
    }

    @Test
    public void bookCanBeCheckout(){
        bookController.checkoutBook("1");
        assertThat(outContent.toString(), containsString("Checkout Successfully! Hope you enjoy!"));
    }

    @Test
    public void bookCannotBeCheckout(){
        bookController.checkoutBook("s");
        assertThat(outContent.toString(), containsString("This book is not available to checkout"));
    }

    @Test
    public void bookCanBeReturn(){
        book.setAvailable(false);
        book.setUserId("1");
        bookController.returnBook("1");
        assertThat(outContent.toString(), containsString("Return Successfully! Thank you!"));
    }

    @Test
    public void bookCannotBeReturn(){
        bookController.returnBook("2");
        assertThat(outContent.toString(), containsString("This book is not available to return"));
    }

}
