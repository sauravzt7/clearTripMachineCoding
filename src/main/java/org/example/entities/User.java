package org.example.entities;

import org.example.enums.Genre;

import java.util.UUID;

public class User {

    private UUID id;
    private String username;
    private Genre preferredGenre;

    public User(String username, Genre preferredGenre) {
        this.username = username;
        this.preferredGenre = preferredGenre;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Genre getPreferredGenre() {
        return preferredGenre;
    }

    public void setPreferredGenre(Genre preferredGenre) {
        this.preferredGenre = preferredGenre;
    }
}
