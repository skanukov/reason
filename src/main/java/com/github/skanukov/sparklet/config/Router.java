package com.github.skanukov.sparklet.config;

import static spark.Spark.get;

/**
 * Handles routes for application.
 */
public final class Router {
    /**
     * Creates router.
     */
    public Router() {
    }

    /**
     * Defines routes for application.
     *
     * @return Router for fluent interface.
     */
    public Router route() {
        get("/hello", (req, res) -> "Hello World");
        return this;
    }
}
