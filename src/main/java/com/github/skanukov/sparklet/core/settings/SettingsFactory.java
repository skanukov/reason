package com.github.skanukov.sparklet.core.settings;

import com.github.skanukov.sparklet.core.json.JsonEngineFactory;
import com.github.skanukov.sparklet.core.lang.FileUtils;
import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * Holds the application settings.
 */
public final class SettingsFactory {
    private static final String SETTINGS_FILE_PATH = "./config/application.json";

    private SettingsFactory() {
    }

    // Lazy initialization
    private static class SettingsHolder {
        private static final JsonObject INSTANCE = loadFromFile();
    }

    /**
     * Returns the application settings.
     *
     * @return The application settings.
     */
    public static JsonObject getSettings() {
        return SettingsHolder.INSTANCE;
    }

    private static JsonObject loadFromFile() {
        String settingsFileContent = null;
        try {
            settingsFileContent = FileUtils.readAllText(SETTINGS_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return JsonEngineFactory.getJsonEngine().fromJson(settingsFileContent, JsonObject.class);
    }
}
