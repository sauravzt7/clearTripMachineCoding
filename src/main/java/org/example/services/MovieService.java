package org.example.services;

import org.example.entities.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MovieService {
    private Map<UUID, Movie> movieRegistry;

    public void addMovie(Movie movie) {
        if(movieRegistry.containsKey(movie.getId())) {
            throw new IllegalArgumentException("Movie already exists");
        }
        movieRegistry.put(movie.getId(), movie);
        System.out.println("Movie added: " + movie.getId());
    }

    public Movie getMovie(UUID id) {
        if(movieRegistry.containsKey(id)) {
            return movieRegistry.get(id);
        }
        throw new IllegalArgumentException("Movie not found");
    }
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieRegistry.values());
    }

}