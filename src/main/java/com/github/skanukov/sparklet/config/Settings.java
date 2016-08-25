package com.github.skanukov.sparklet.config;

import com.github.skanukov.sparklet.core.json.JsonEngineFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Holds application settings.
 */
public class Settings {
    private static final String SETTINGS_FILE_PATH = "./config/application.json";

    private boolean debug;

    private Settings() {
    }

    /**
     * Indicates if the application in debug mode.
     *
     * @return True if debug mode enabled, false otherwise.
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * Loads application settings from pre-defined file.
     *
     * @return The Settings instance.
     */
    public static Settings load() {
        Path settingFilePath = Paths.get(SETTINGS_FILE_PATH);
        String settingsFileContent = null;
        try {
            settingsFileContent = new String(Files.readAllBytes(settingFilePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return JsonEngineFactory.getJsonEngine().fromJson(settingsFileContent, Settings.class);
    }
}
