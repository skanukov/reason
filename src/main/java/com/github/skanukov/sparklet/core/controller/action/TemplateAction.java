package com.github.skanukov.sparklet.core.controller.action;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

/**
 * Defines interface for applications actions rendering templates.
 */
public interface TemplateAction {
    /**
     * Handles the http request.
     *
     * @param req The http request.
     * @param res The http request.
     * @return ModelAndView containing the template attributes and the path to template.
     */
    ModelAndView call(Request req, Response res);
}
