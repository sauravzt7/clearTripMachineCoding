package org.example.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private int capacity;
    private Map<K, V> cache;
    private LinkedHashMap<K, V> lruCache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lruCache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public V get(K key) {
        if(lruCache.containsKey(key)) {
            return lruCache.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if(lruCache.size() >= this.capacity) {
            Iterator<K> iterator = lruCache.keySet().iterator();
            K oldestKey = iterator.next();
            lruCache.remove(oldestKey);
            cache.remove(oldestKey);
        }
        lruCache.put(key, value);
        cache.put(key, value);
    }

    public boolean containsKey(K key) {
        return lruCache.containsKey(key);
    }

    public void clear() {
        cache.clear();
        lruCache.clear();
    }

    public int size() {
        return lruCache.size();
    }
}

