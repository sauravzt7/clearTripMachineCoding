package org.example.services;

import org.example.entities.Movie;

import java.util.List;

public interface SearchInterface {
    List<Movie> searchByTitle(String title);
    List<Movie> searchByGenre(String genre);
    List<Movie> searchByYear(String year);





}
