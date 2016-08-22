package com.github.skanukov.sparklet.apps.web.controllers.home;

import com.github.skanukov.sparklet.core.action.HtmlAction;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Home controller IndexAction action.
 */
public class IndexAction extends HomeAction implements HtmlAction {
    /**
     * Handles the http request.
     *
     * @param req The http request.
     * @param res The http request.
     * @return HttpAction result.
     */
    @Override
    public Object call(Request req, Response res) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", "Hello, world!");
        return renderTemplate(new ModelAndView(attributes, "./templates/web/home/index.ftl"));
    }
}
