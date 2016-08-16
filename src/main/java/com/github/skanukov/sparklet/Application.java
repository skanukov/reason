package com.github.skanukov.sparklet;

import com.github.skanukov.sparklet.config.RouteDispatcher;
import com.github.skanukov.sparklet.config.Settings;
import spark.servlet.SparkApplication;

public class Application implements SparkApplication {
    private Settings settings;

    //<editor-fold desc="Singleton region.">
    private Application() {
    }

    // Lazy singleton initialization
    private static class SingletonHolder {
        private static final Application INSTANCE = new Application();
    }

    /**
     * Returns the MyApplication singleton instance.
     *
     * @return The MyApplication singleton instance.
     */
    public static Application getInstance() {
        return SingletonHolder.INSTANCE;
    }
    //</editor-fold>

    /**
     * Entry point for Sparklet application.
     */
    @Override
    public void init() {
        settings = Settings.load();
        new RouteDispatcher().dispatch();
    }

    /**
     * Returns the application settings instance.
     *
     * @return The application settings instance.
     */
    public Settings getSettings() {
        return settings;
    }
}
