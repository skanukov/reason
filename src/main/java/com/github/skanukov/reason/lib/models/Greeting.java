package com.github.skanukov.reason.lib.models;

/**
 * Sample model to render JSON from.
 */
public class Greeting {
    private final long id;
    private final String message;

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
