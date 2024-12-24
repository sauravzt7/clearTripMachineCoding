package org.example.services.searchstrategy;

import org.example.entities.Movie;

import java.util.List;

public interface SearchStrategy {
    List<Movie> search(String... params);
}
