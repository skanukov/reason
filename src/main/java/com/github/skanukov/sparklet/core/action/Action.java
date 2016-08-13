package com.github.skanukov.sparklet.core.action;

import spark.Request;
import spark.Response;

/**
 * Defines interface for applications actions.
 */
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
