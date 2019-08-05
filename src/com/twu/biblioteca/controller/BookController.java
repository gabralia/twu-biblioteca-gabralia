package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    private List<Book> bookList = new ArrayList<Book>();

    public void showBookList(){
        System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s%n",
                "-- Id --", "-- Title --", "-- Author --", "-- PublishYear --", "-- Price --","-- is Available --");
        for(Book book : bookList) {
            System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s%n",
                    book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getPrice(),book.getAvailable());
        }
    }

    public void checkoutBook(){

    }

    public void returnBook(){

    }

    public void addBook(Book book){
        bookList.add(book);
    }
}
