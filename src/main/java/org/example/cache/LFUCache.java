package org.example.cache;

import java.util.*;

public class LFUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final Map<K, Integer> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            frequencyMap.put(key, frequencyMap.get(key) + 1);
            return cache.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.size() >= capacity) {

            K lfuKey = frequencyMap.entrySet().stream()
                    .min(Map.Entry.comparingByValue())
                    .get().getKey();
            cache.remove(lfuKey);
            frequencyMap.remove(lfuKey);
        }
        cache.put(key, value);
        frequencyMap.put(key, 1);
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    public void clear() {
        cache.clear();
        frequencyMap.clear();
    }

    public int size() {
        return cache.size();
    }
}
