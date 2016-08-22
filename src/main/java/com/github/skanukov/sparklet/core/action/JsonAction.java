package com.github.skanukov.sparklet.core.action;

import com.google.gson.Gson;
import spark.Response;

/**
 * Defines interface for applications actions rendering JSON.
 */
@FunctionalInterface
public interface JsonAction extends HttpAction {
    /**
     * Renders object to the response in json format.
     *
     * @param res    The response which type will be set to 'application/json'.
     * @param object The object to render in json format.
     * @return The object rendered in json.
     */
    default String renderJson(Response res, Object object) {
        res.type("application/json");
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}