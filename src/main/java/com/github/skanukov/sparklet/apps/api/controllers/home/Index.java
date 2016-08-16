package com.github.skanukov.sparklet.apps.api.controllers.home;

import com.github.skanukov.sparklet.core.controller.action.Action;
import spark.Request;
import spark.Response;

import java.util.Arrays;

/**
 * Home controller Index action.
 */
public class Index extends HomeAction implements Action {
    /**
     * Handles the http request.
     *
     * @param req The http request.
     * @param res The http request.
     * @return Action result.
     */
    @Override
    public Object call(Request req, Response res) {
        return renderJson(Arrays.asList(1, 2, 3));
    }
}
