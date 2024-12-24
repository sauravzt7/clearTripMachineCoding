package org.example.services;

import org.example.cache.LRUCache;
import org.example.cache.LFUCache;
import org.example.entities.Movie;

import java.util.*;

public class CacheService {
    private final Map<Integer, LRUCache<String, Movie>> l1Cache; // User-specific (L1)
    private final LFUCache<String, Movie> l2Cache;              // Global popular (L2)
    private final Map<String, Movie> primaryStore;              // Primary store

    private int l1Hits = 0;
    private int l2Hits = 0;
    private int primaryHits = 0;
    private int totalSearches = 0;

    public CacheService() {
        this.l1Cache = new HashMap<>();
        this.l2Cache = new LFUCache<>(20); // Max 20 entries for L2
        this.primaryStore = new HashMap<>();
    }

    // Register movies in the primary store
    public void addMovie(Movie movie) {
        primaryStore.put(movie.getTitle(), movie);
    }

    // Search movie by title
    public Movie searchMovie(int userId, String title) {
        totalSearches++;

        // Check L1 Cache
        LRUCache<String, Movie> userCache = l1Cache.computeIfAbsent(userId, k -> new LRUCache<>(5)); // Max 5 entries for L1
        if (userCache.containsKey(title)) {
            l1Hits++;
            return userCache.get(title);
        }

        // Check L2 Cache
        if (l2Cache.containsKey(title)) {
            l2Hits++;
            Movie movie = l2Cache.get(title);
            userCache.put(title, movie); // Add to L1 cache
            return movie;
        }

        // Check Primary Store
        if (primaryStore.containsKey(title)) {
            primaryHits++;
            Movie movie = primaryStore.get(title);

            // Update both caches
            userCache.put(title, movie);
            l2Cache.put(title, movie);
            return movie;
        }

        // Movie not found
        return null;
    }

    // View Cache Statistics
    public void viewCacheStats() {
        System.out.println("L1 Cache Hits: " + l1Hits);
        System.out.println("L2 Cache Hits: " + l2Hits);
        System.out.println("Primary Store Hits: " + primaryHits);
        System.out.println("Total Searches: " + totalSearches);
    }

    // Clear specific cache
    public void clearCache(String cacheLevel) {
        if ("L1".equalsIgnoreCase(cacheLevel)) {
            l1Cache.clear();
            System.out.println("L1 cache cleared.");
        } else if ("L2".equalsIgnoreCase(cacheLevel)) {
            l2Cache.clear();
            System.out.println("L2 cache cleared.");
        } else {
            System.out.println("Invalid cache level.");
        }
    }
}
