package com.github.skanukov.sparklet.routing;

import com.github.skanukov.sparklet.Application;
import com.github.skanukov.sparklet.core.controller.action.TemplateAction;
import com.github.skanukov.sparklet.core.routing.Router;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.FileLoader;
import spark.template.pebble.PebbleTemplateEngine;

/**
 * Handles routes for html rendering.
 */
public abstract class PebbleRouter extends Router {
    /**
     * Creates router with default settings.
     */
    public PebbleRouter() {
        super();
    }

    /**
     * Creates router and mounts the base path.
     *
     * @param basePath The base path for router.
     */
    public PebbleRouter(String basePath) {
        super(basePath);
    }

    /**
     * Handles GET request and renders the html template.
     *
     * @param path   The path to handle.
     * @param action The action rendering a template to use for handling.
     * @return The Router instance for fluent interface.
     */
    protected Router get(String path, TemplateAction action) {
        PebbleEngine pebbleEngine = new PebbleEngine(new FileLoader());
        if (Application.getInstance().getSettings().isDebug()) {
            pebbleEngine.setTemplateCache(null);
        }
        super.get(path, action, new PebbleTemplateEngine(pebbleEngine));
        return this;
    }
}
