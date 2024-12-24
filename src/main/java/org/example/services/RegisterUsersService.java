package org.example.services;
import org.example.entities.User;

import java.util.*;

public class RegisterUsersService {
    private Map<UUID, User> userRegistry;

    public void register(User user) {

        if(userRegistry.containsKey(user.getId())) {
            System.out.println("User " + user.getId() + " is already registered");
            throw new IllegalArgumentException("User already registered");
        }
        userRegistry.put(user.getId(), user);
        System.out.println("User " + user.getId() + " has been registered");
    }

    public void register(List<User> users) {
        for(User user : users) {
            register(user);
        }
        System.out.println("User " + users.size() + " has been registered");

    }

    public User getUserById(UUID userId) {
        if (!userRegistry.containsKey(userId)) {
            throw new NoSuchElementException("User ID not found: " + userId);
        }
        return userRegistry.get(userId);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userRegistry.values());
    }

    public void clearUsers() {
        userRegistry.clear();
        System.out.println("All users cleared.");
    }

}
