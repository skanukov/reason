package com.github.skanukov.sparklet.apps.web.config;

import com.github.skanukov.sparklet.apps.web.controllers.home.Index;
import com.github.skanukov.sparklet.core.routing.Router;

/**
 * Handles all routes for the current application.
 */
public final class WebRouter extends Router {
    /**
     * Creates router for the current application with default settings.
     */
    public WebRouter() {
        super();
    }

    /**
     * Creates router for the current application and mounts the base path.
     *
     * @param basePath The base path for router.
     */
    public WebRouter(String basePath) {
        super(basePath);
    }

    /**
     * Defines all routes for the current applications.
     *
     * @return The Router instance for fluent interface.
     */
    @Override
    public Router route() {
        get("/", new Index());
        return this;
    }
}
