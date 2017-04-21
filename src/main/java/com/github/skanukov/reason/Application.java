package com.github.skanukov.reason;

import com.github.skanukov.reason.core.settings.SettingsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.servlet.SparkApplication;

/**
 * Defines entry point for Reason application.
 */
public class Application implements SparkApplication {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    /**
     * Entry point for Reason application.
     */
    @Override
    public void init() {
        logger.info("Application starting...");
        if (SettingsFactory.getSettings().get("isDebug").getAsBoolean()) {
            logger.info("Debug mode enabled");
        }
        new ApplicationDispatcher().dispatch();
    }
}
