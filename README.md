
# Multi-Level Cache Movie Management System

## Problem Statement
We are developing a movie content management system - ZipReel, for a streaming platform, 
where users can search and access movie information efficiently. 
The system needs to handle frequent searches and provide fast responses through a **multi-level caching mechanism**.

### Features to Implement
1. Registration of movies and users in the system.
2. Implementation of a multi-level cache to optimize search operations.
3. Efficient retrieval of movie information based on various parameters.

The system should provide lightning-fast search results via intelligent caching.

---

## Explanations

### What is a Multi-Level Cache?
- **L1 Cache**: User-specific recent searches (max 5 entries per user).
- **L2 Cache**: Global popular searches (max 20 entries).
- **Primary Store**: All movie data stored in-memory.

### What is a Cache Hit/Miss?
- **Cache Hit**: Data found in any cache level.
- **Cache Miss**: Data not found, requiring search in the main database.

**Cache Lookup Order**: L1 -> L2 -> Primary Store.

---

## Requirements

### System should be able to:

#### 1. Add Movies
- **Attributes**:
    - Movie ID (unique)
    - Title
    - Genre
    - Release Year
    - Rating

#### 2. Register Users
- **Attributes**:
    - User ID (unique)
    - Name
    - Preferred Genre

#### 3. Implement Multi-Level Caching
- **L1 Cache**: User-specific cache
    - Max 5 entries per user
    - Implements **LRU (Least Recently Used)** eviction policy.
- **L2 Cache**: Global popular searches cache
    - Max 20 entries
    - Implements **LFU (Least Frequently Used)** eviction policy.

#### 4. Handle Search Operations
- Search by title
- Search by genre
- Search by release year
- Multiple filter combination

---

## Search Process
1. Check **L1 cache** (user-specific).
2. If not found, check **L2 cache** (global popular).
3. If not found, search in the **Primary Store** (main database).
4. Update caches based on search results.

---

## Bonus Requirements
- View cache-level-wise cache hits (**L1, L2, Primary Store**).
- Display the total number of searches.

---

## Commands

### Add Movie
```
ADD_MOVIE <id> <title> <genre> <year> <rating>
Example: ADD_MOVIE 1 "Inception" "Sci-Fi" 2010 9.5
Output: Movie 'Inception' added successfully.
```

### Add User
```
ADD_USER <id> <name> <preferred_genre>
Example: ADD_USER 1 "John" "Action"
Output: User 'John' added successfully.
```

### Search
```
SEARCH <user_id> <search_type> <search_value>
Example: SEARCH 1 GENRE "Action"
Output: [List of movies with cache level indicator] {title} (Found in {cache_level})
```

### Multi-Filter Search
```
SEARCH_MULTI <user_id> <genre> <year> <min_rating>
Example: SEARCH_MULTI 1 "Action" 2020 8.0
Output: [List of filtered movies with cache level indicator]
```

### View Cache Statistics
```
VIEW_CACHE_STATS
Output:
L1 Cache Hits: X
L2 Cache Hits: Y
Primary Store Hits: Z
Total Searches: N
```

### Clear Cache
```
CLEAR_CACHE <cache_level>
Example: CLEAR_CACHE L1
Output: L1 cache cleared successfully.
```

---

## Guidelines
1. Input can be read from a file or STDIN or coded in a driver method. **No API or UI.**
2. Output can be written to a file or STDOUT. **No API.**
3. Store all interim/output data in-memory data structures. **No databases allowed.**
4. Language should be **Java only**.
5. Coding duration is **90 minutes**.
6. **Do not use ChatGPT or any other source to replicate the requirement.**

---

## Expectations
1. The code should be demo-able and functionally correct.
2. Proper exception handling for edge cases:
    - Invalid movie/user IDs.
    - Duplicate entries.
    - Invalid search parameters.
3. Code should be modular and follow **OOP principles**.
4. Efficient implementation of **cache eviction policies**.
5. Clear separation of concerns between:
    - **Data storage**
    - **Cache management**
    - **Search operations**
6. Proper **unit tests** for critical components are good to have.

---

This README outlines the functionality, requirements, and commands necessary to build and test the multi-level cache movie management system in Java. Ensure compliance with the guidelines and expectations provided above.
