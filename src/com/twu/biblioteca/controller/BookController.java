package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    private List<Book> bookList = new ArrayList<>();

    public void showBookList(){
        System.out.printf(
                "%-30s%-30s%-30s%-30s%-30s%-30s%n",
                "-- Id --",
                "-- Title --",
                "-- Author --",
                "-- PublishYear --",
                "-- Price --",
                "-- is Available --"
        );
        for(Book book : bookList) {
            System.out.printf(
                    "%-30s%-30s%-30s%-30s%-30s%-30s%n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublishYear(),
                    book.getPrice(),
                    book.getAvailable()?"yes":"no"
            );
        }
    }

    public void checkoutBook(String id){
        Book checkoutBook = bookList.stream()
                .filter(book -> book.getId().equals(id) && book.getAvailable())
                .findFirst().orElse(null);
        if(checkoutBook != null) {
            checkoutBook.setAvailable(false);
            checkoutBook.setUserId(UserController.getCurrentUser());
            System.out.println("Checkout Successfully! Hope you enjoy!");
        }else {
            System.out.println("This book is not available to checkout");
        }
    }

    public void returnBook(String id){
        String userId = UserController.getCurrentUser();
        Book returnBook = bookList.stream()
                .filter(book -> book.getId().equals(id) && !book.getAvailable() && book.getUserId().equals(userId))
                .findFirst().orElse(null);
        if(returnBook != null) {
            returnBook.setAvailable(true);
            returnBook.setUserId(null);
            System.out.println("Return Successfully! Thank you!");
        }else {
            System.out.println("This book is not available to return");
        }
    }

    public void addBook(Book book){
        bookList.add(book);
    }
}
