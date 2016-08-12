package com.github.skanukov.sparklet.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.get;

/**
 * Handles routes for application.
 */
public final class Router {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Creates router.
     */
    public Router() {
        logger.info("Router created.");
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
