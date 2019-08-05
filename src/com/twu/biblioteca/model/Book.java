package com.twu.biblioteca.model;

public class Book {

    private String id;
    private String title;
    private String author;
    private String publishYear;
    private Double price;
    private Boolean available;

    public Book(String id, String title, String author, String publishYear, Double price, Boolean available)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
        this.available = available;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getPublishYear(){
        return this.publishYear;
    }

    public Double getPrice(){
        return this.price;
    }

    public Boolean getAvailable(){
        return this.available;
    }

    public void setAvailable(Boolean available){
        this.available =  available;
    }
}
