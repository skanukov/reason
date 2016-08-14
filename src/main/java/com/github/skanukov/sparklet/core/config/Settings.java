package com.github.skanukov.sparklet.core.config;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Settings {
    private static final String SETTINGS_FILE_PATH = "./config/application.json";

    private boolean debug;

    private Settings() {
    }

    public static Settings load() {
        Settings settings = null;
        Path settingFilePath = Paths.get(SETTINGS_FILE_PATH);
        try {
            String settingsFileContent = new String(Files.readAllBytes(settingFilePath), StandardCharsets.UTF_8);
            Gson gson = new Gson();
            settings = gson.fromJson(settingsFileContent, Settings.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return settings;
    }
}
