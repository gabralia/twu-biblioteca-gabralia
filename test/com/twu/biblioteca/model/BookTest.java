package com.twu.biblioteca.model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class BookTest {

    private Book book = new Book("1","The Secret Garden","Frances Hodgson Burnett","2014",28.0);

    @Test
    public void getId(){
        assertThat(book.getId(),is("1"));
    }

    @Test
    public void getTitle(){
        assertThat(book.getTitle(),is("The Secret Garden"));
    }

    @Test
    public void getAuthor(){
        assertThat(book.getAuthor(),is("Frances Hodgson Burnett"));
    }

    @Test
    public void getPublishYear(){
        assertThat(book.getPublishYear(),is("2014"));
    }

    @Test
    public void getPrice(){
        assertThat(book.getPrice(),is(28.0));
    }

    @Test
    public void getAvailable(){
        assertThat(book.getAvailable(),is(true));
    }

    @Test
    public void setAvailable(){
        book.setAvailable(false);
        assertThat(book.getAvailable(),is(false));
    }

}
