package com.github.skanukov.reason.core.controller;

import com.github.skanukov.reason.core.json.JsonEngineFactory;
import com.github.skanukov.reason.core.template.TemplateEngineFactory;
import spark.ModelAndView;
import spark.Response;

/**
 * Base class for the application controllers.
 */
public class ApplicationController {
    /**
     * Renders HTML template to the response.
     *
     * @param modelAndView The data containing models and template path.
     * @return The rendered HTML template.
     */
    protected String renderTemplate(ModelAndView modelAndView) {
        return TemplateEngineFactory.getTemplateEngine().render(modelAndView);
    }

    /**
     * Renders object to the response in json format.
     *
     * @param response The response which type will be set to 'application/json'.
     * @param object   The object to render in json format.
     * @return The object rendered in json.
     */
    protected String renderJson(Response response, Object object) {
        response.type("application/json");
        return JsonEngineFactory.getJsonEngine().toJson(object);
    }
}
