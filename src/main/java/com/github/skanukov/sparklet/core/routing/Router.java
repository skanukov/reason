package com.github.skanukov.sparklet.core.routing;

import com.github.skanukov.sparklet.core.controller.action.TemplateAction;
import spark.Spark;
import spark.template.pebble.PebbleTemplateEngine;

/**
 * Base class for all application routers.
 */
public abstract class Router {
    private String basePath = "";

    /**
     * Creates router with default settings.
     */
    public Router() {
    }

    /**
     * Creates router and mounts the base path.
     *
     * @param basePath The base path for router.
     */
    public Router(String basePath) {
        mount(basePath);
    }

    /**
     * Mounts the base path.
     *
     * @param basePath The base path for router.
     */
    public Router mount(String basePath) {
        this.basePath = basePath;
        return this;
    }

    /**
     * Abstract method defines all routes.
     *
     * @return Router for fluent interface.
     */
    public abstract Router route();

    /**
     * Handles GET request.
     *
     * @param path   The path to handle.
     * @param action The action rendering a template to use for handling.
     * @return Router for fluent interface.
     */
    protected Router get(String path, TemplateAction action) {
        Spark.get(basePath + path, action::call, new PebbleTemplateEngine());
        return this;
    }
}
