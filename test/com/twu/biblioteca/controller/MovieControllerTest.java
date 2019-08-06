package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Movie;
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

public class MovieControllerTest {

    private Movie movie = new Movie("1","The Princess Diaries","Garry Marshall","2001","unrated");

    private MovieController movieController = new MovieController();

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
    public void addMovies() {
        movieController.addMovie(movie);
    }

    @Test
    public void movieListCanBeOutput(){
        movieController.showMovieList();
        assertThat(outContent.toString(), containsString(String.format(
                "%-30s%-30s%-30s%-30s%-30s%-30s%n",
                movie.getId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getYear(),
                movie.getRating(),
                movie.getAvailable()?"yes":"no"
        )));
    }

    @Test
    public void movieCanBeCheckout(){
        movieController.checkoutMovie("1");
        assertThat(outContent.toString(), containsString("Checkout Successfully! Hope you enjoy!"));
    }

    @Test
    public void movieCannotBeCheckout(){
        movieController.checkoutMovie("s");
        assertThat(outContent.toString(), containsString("This movie is not available to checkout"));
    }

}

