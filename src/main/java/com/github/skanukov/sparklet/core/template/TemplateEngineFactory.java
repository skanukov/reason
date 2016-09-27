package com.github.skanukov.sparklet.core.template;

import com.github.skanukov.sparklet.core.config.SettingsFactory;
import freemarker.template.Configuration;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.File;
import java.io.IOException;

/**
 * Holds the template engine.
 */
public final class TemplateEngineFactory {
    private TemplateEngineFactory() {
    }

    // Lazy initialization
    private static class TemplateEngineHolder {
        private static final TemplateEngine INSTANCE = createTemplateEngine();
    }

    /**
     * Returns the application template engine.
     *
     * @return The application template engine.
     */
    public static TemplateEngine getTemplateEngine() {
        return TemplateEngineHolder.INSTANCE;
    }

    /**
     * Creates the template engine.
     *
     * @return The template engine.
     */
    private static TemplateEngine createTemplateEngine() {
        File currentWorkingDir = new File(System.getProperty("user.dir"));
        Configuration templateEngineConfig = new Configuration();
        try {
            templateEngineConfig.setDirectoryForTemplateLoading(currentWorkingDir);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        if (SettingsFactory.getSettings().get("isDebug").getAsBoolean()) {
            templateEngineConfig.setTemplateUpdateDelay(0);
        }
        return new FreeMarkerEngine(templateEngineConfig);
    }
}
