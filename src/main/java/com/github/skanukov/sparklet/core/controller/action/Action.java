package com.github.skanukov.sparklet.core.controller.action;

import spark.Request;
import spark.Response;

/**
 * Defines interface for applications actions rendering templates.
 */
@FunctionalInterface
public interface Action {
    /**
     * Handles the http request.
     *
     * @param req The http request.
     * @param res The http request.
     * @return Action result.
     */
    Object call(Request req, Response res);
}
