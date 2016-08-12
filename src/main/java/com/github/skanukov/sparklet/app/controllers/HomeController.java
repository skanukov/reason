package com.github.skanukov.sparklet.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.util.concurrent.atomic.AtomicInteger;

public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static final AtomicInteger count = new AtomicInteger(0);

    public HomeController() {
        logger.info("HomeController::constructor called");
    }

    public Object index(Request req, Response res) {
        logger.info(String.format("HomeController::index action called %d", count.incrementAndGet()));
        return "Hello, world!";
    }
}
