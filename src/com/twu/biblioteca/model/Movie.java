package com.twu.biblioteca.model;

public class Movie {

    private String id;
    private String title;
    private String director;
    private String year;
    private String rating;
    private Boolean available;
    private String userId;

    public Movie(String id, String title, String director, String year, String rating){
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.available = true;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDirector(){
        return this.director;
    }

    public String getYear(){
        return this.year;
    }

    public String getRating(){
        return this.rating;
    }

    public Boolean getAvailable(){
        return this.available;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAvailable(Boolean available){
        this.available = available;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

}
