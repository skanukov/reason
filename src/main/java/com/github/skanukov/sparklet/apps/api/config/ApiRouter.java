package com.github.skanukov.sparklet.apps.api.config;

import com.github.skanukov.sparklet.core.route.Router;

/**
 * Handles all routes for the current application.
 */
public final class ApiRouter extends Router {
    /**
     * Creates router for the current application with default settings.
     */
    public ApiRouter() {
        super();
    }

    /**
     * Creates router for the current application and mounts the base path.
     *
     * @param basePath The base path for router.
     */
    public ApiRouter(String basePath) {
        super(basePath);
    }

    /**
     * Defines all routes for the current applications.
     */
    @Override
    public void route() {
        get("/", new com.github.skanukov.sparklet.apps.api.controllers.home.IndexAction());
        get("/users", new com.github.skanukov.sparklet.apps.api.controllers.users.IndexAction());
    }
}
