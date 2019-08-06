package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieController {

    private List<Movie> movieList = new ArrayList<>();

    public void showMovieList(){
        System.out.printf(
                "%-30s%-30s%-30s%-30s%-30s%-30s%n",
                "-- Id --",
                "-- Title --",
                "-- Director --",
                "-- Year --",
                "-- Rating --",
                "-- is Available --"
        );
        for(Movie movie : movieList) {
            System.out.printf(
                    "%-30s%-30s%-30s%-30s%-30s%-30s%n",
                    movie.getId(),
                    movie.getTitle(),
                    movie.getDirector(),
                    movie.getYear(),
                    movie.getRating(),
                    movie.getAvailable()?"yes":"no"
            );
        }
    }

    public void checkoutMovie(String id){
        Movie checkoutMovie = movieList.stream()
                .filter(movie -> movie.getId().equals(id) && movie.getAvailable())
                .findFirst().orElse(null);
        if(checkoutMovie != null) {
            checkoutMovie.setAvailable(false);
            checkoutMovie.setUserId(UserController.getCurrentUser());
            System.out.println("Checkout Successfully! Hope you enjoy!");
        }else {
            System.out.println("This movie is not available to checkout");
        }
    }

    public void addMovie(Movie movie){
        movieList.add(movie);
    }
}
