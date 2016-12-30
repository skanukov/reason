package com.github.skanukov.reason.core.json;

import com.google.gson.Gson;

/**
 * Holds the json engine.
 */
public final class JsonEngineFactory {
    private JsonEngineFactory() {
    }

    // Lazy initialization
    private static class JsonEngineHolder {
        private static final Gson INSTANCE = new Gson();
    }

    /**
     * Returns the application json engine.
     *
     * @return The application json engine.
     */
    public static Gson getJsonEngine() {
        return JsonEngineHolder.INSTANCE;
    }
}
