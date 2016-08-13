package com.github.skanukov.sparklet.config;

import com.github.skanukov.sparklet.apps.web.config.WebRouter;
import com.github.skanukov.sparklet.core.routing.Router;

/**
 * Handles all routes for applications.
 */
public final class AppRouter extends Router {
    /**
     * Defines mount points for applications.
     *
     * @return Router for fluent interface.
     */
    @Override
    public Router route() {
        new WebRouter().route();
        return this;
    }
}
