package com.github.skanukov.sparklet.config;

import com.github.skanukov.sparklet.apps.api.config.ApiRouter;
import com.github.skanukov.sparklet.apps.web.config.WebRouter;
import com.github.skanukov.sparklet.core.routing.Dispatcher;

/**
 * Handles all routes for applications.
 */
public final class RouteDispatcher implements Dispatcher {
    /**
     * Defines mount points for applications.
     */
    @Override
    public void dispatch() {
        new WebRouter().route();
        new ApiRouter("/api").route();
    }
}
