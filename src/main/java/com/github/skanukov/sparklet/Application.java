package com.github.skanukov.sparklet;

import com.github.skanukov.sparklet.config.RouteDispatcher;
import com.github.skanukov.sparklet.config.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.servlet.SparkApplication;

/**
 * Defines entry point for Sparklet application.
 */
public enum Application implements SparkApplication {
    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private Settings settings;

    /**
     * Entry point for Sparklet application.
     */
    @Override
    public void init() {
        logger.info("Application starting...");
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
