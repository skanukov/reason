package com.github.skanukov.sparklet.core.routing;

import com.github.skanukov.sparklet.core.action.Action;
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
     * @param action The action to use for handling.
     * @return Router for fluent interface.
     */
    protected Router get(String path, Action action) {
        Spark.get(basePath + path, action::call);
        return this;
    }
}
