package com.github.skanukov.sparklet.apps.api.controllers;

import com.google.gson.Gson;
import spark.Response;

/**
 * Base class for the current application actions.
 */
public abstract class ApiAction {
    /**
     * Renders object to the response in json format.
     *
     * @param res    The response which type will be set to 'application/json'.
     * @param object The object to render in json format.
     * @return Rendered in json format object.
     */
    protected String renderJson(Response res, Object object) {
        res.type("application/json");
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
