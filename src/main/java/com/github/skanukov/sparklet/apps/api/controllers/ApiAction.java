package com.github.skanukov.sparklet.apps.api.controllers;

import com.google.gson.Gson;
import spark.Response;

/**
 * Base class for the current application actions.
 */
public abstract class ApiAction {
    protected String renderJson(Response res, Object object) {
        res.type("application/json");
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
