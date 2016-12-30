package com.github.skanukov.reason.core.template;

import com.github.skanukov.reason.core.settings.SettingsFactory;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.FileLoader;
import spark.TemplateEngine;
import spark.template.pebble.PebbleTemplateEngine;

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
        PebbleEngine pebbleEngine = new PebbleEngine(new FileLoader());
        // Disable template caching for debug mode.
        if (SettingsFactory.getSettings().get("isDebug").getAsBoolean()) {
            pebbleEngine.setTemplateCache(null);
        }
        return new PebbleTemplateEngine(pebbleEngine);
    }
}
