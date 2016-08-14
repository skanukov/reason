package com.github.skanukov.sparklet;

import com.github.skanukov.sparklet.config.AppRouter;
import com.github.skanukov.sparklet.config.Settings;

public class Application {
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
     *
     * @return The Application instance for fluent interface.
     */
    public Application init() {
        settings = Settings.load();
        new AppRouter().route();
        return this;
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
