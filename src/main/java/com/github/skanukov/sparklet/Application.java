package com.github.skanukov.sparklet;

import com.github.skanukov.sparklet.config.RouteDispatcher;
import com.github.skanukov.sparklet.config.Settings;
import com.github.skanukov.sparklet.core.template.FreeMarkerTemplateEngine;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.TemplateEngine;
import spark.servlet.SparkApplication;

/**
 * Defines entry point for Sparklet application.
 */
public final class Application implements SparkApplication {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private Settings settings;
    private TemplateEngine templateEngine;
    private Gson jsonEngine;

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
        logger.info("Application starting...");
        settings = Settings.load();
        templateEngine = FreeMarkerTemplateEngine.createTemplateEngine();
        jsonEngine = new Gson();
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

    /**
     * Returns the application template engine.
     *
     * @return The application template engine.
     */
    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

    /**
     * Returns the application JSON engine.
     *
     * @return The application JSON engine.
     */
    public Gson getJsonEngine() {
        return jsonEngine;
    }
}
