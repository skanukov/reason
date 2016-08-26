package com.github.skanukov.sparklet;

import com.github.skanukov.sparklet.config.RouteDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.servlet.SparkApplication;

/**
 * Defines entry point for Sparklet application.
 */
public enum Application implements SparkApplication {
    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     * Entry point for Sparklet application.
     */
    @Override
    public void init() {
        logger.info("Application starting...");
        new RouteDispatcher().dispatch();
    }
}
