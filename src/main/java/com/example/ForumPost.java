// Post format

package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ForumPost {
    // instance variables
    private String message;
    private String title;
    private String author;
    private String timestamp;

    // No-argument constructor for Firebase deserialization
    public ForumPost() {
        // Default constructor required for calls to DataSnapshot.getValue(ForumPost.class)
    }

    // post constructor initializes variables
    public ForumPost(String message, String author, String title) {
        this.message = message;
        this.author = author;
        this.title = title;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // Added seconds for better uniqueness if needed

    }

    // accessors (Firebase requires public getters)
    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Setters (optional but good practice for Firebase updates)
    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    // Output of post
    @Override
    public String toString() {
        return "[" + timestamp + "] " + author + " has written a tweet \"" + title + "\": " + message;
    }
}