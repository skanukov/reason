package com.github.skanukov.sparklet.core.action;

import com.github.skanukov.sparklet.Application;
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
        return Application.getInstance().getJsonEngine().toJson(object);
    }
}
