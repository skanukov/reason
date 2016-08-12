package com.github.skanukov.sparklet.config;

import com.github.skanukov.sparklet.app.controllers.HomeController;

import static spark.Spark.get;

/**
 * Handles routes for application.
 */
public final class Router {
    /**
     * Defines routes for application.
     *
     * @return Router for fluent interface.
     */
    public Router route() {
        get("/", new HomeController()::index);
        get("/hello", new HomeController()::index);
        return this;
    }
}
