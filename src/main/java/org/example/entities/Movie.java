package org.example.entities;

import org.example.enums.Genre;

import java.util.Date;
import java.util.UUID;

public class Movie {
    private UUID id;
    private String title;
    private Genre genre;
    private Date releaseDate;
    private double rating;


    public Movie(String title, Genre genre, Date releaseDate, double rating) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = 5.0;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
