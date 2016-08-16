package com.github.skanukov.sparklet.core.routing;

import com.github.skanukov.sparklet.core.controller.action.Action;
import spark.Spark;

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
     */
    public void mount(String basePath) {
        this.basePath = basePath;
    }

    /**
     * Abstract method defines all routes.
     */
    public abstract void route();

    /**
     * Handles GET request.
     *
     * @param path   The path to handle.
     * @param action The action rendering a template to use for handling.
     */
    protected void get(String path, Action action) {
        Spark.get(basePath + path, action::call);
    }
}
