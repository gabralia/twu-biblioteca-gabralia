package com.twu.biblioteca.model;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MovieTest {

    private Movie movie = new Movie("1","The Princess Diaries","Garry Marshall","2001","unrated");

    @Test
    public void getId(){
        assertThat(movie.getId(),is("1"));
    }

    @Test
    public void getTitle(){
        assertThat(movie.getTitle(),is("The Princess Diaries"));
    }

    @Test
    public void getDirector(){
        assertThat(movie.getDirector(),is("Garry Marshall"));
    }

    @Test
    public void getYear(){
        assertThat(movie.getYear(),is("2001"));
    }

    @Test
    public void getRating(){
        assertThat(movie.getRating(),is("unrated"));
    }

    @Test
    public void getAvailable(){
        assertThat(movie.getAvailable(),is(true));
    }

    @Test
    public void setAvailable(){
        movie.setAvailable(false);
        assertThat(movie.getAvailable(),is(false));
    }

}
