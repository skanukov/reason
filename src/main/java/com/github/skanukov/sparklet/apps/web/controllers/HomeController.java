package com.github.skanukov.sparklet.apps.web.controllers;

import com.github.skanukov.sparklet.core.controller.SparkletController;
import com.github.skanukov.sparklet.lib.models.Greeting;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class HomeController extends SparkletController {
    public String actionIndex(Request request, Response response) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", "Hello, world!");
        return renderTemplate(new ModelAndView(attributes, "./templates/web/home/index.peb"));
    }

    public String actionGreet(Request request, Response response) {
        return renderJson(response, new Greeting(1, "Hello, world"));
    }
}
