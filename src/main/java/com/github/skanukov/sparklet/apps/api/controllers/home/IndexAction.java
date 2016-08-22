package com.github.skanukov.sparklet.apps.api.controllers.home;

import com.github.skanukov.sparklet.core.action.JsonAction;
import spark.Request;
import spark.Response;

import java.util.Arrays;

/**
 * Home controller IndexAction action.
 */
public class IndexAction extends HomeAction implements JsonAction {
    /**
     * Handles the http request.
     *
     * @param req The http request.
     * @param res The http request.
     * @return HttpAction result.
     */
    @Override
    public Object call(Request req, Response res) {
        return renderJson(res, Arrays.asList(1, 2, 3));
    }
}
