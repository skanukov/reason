package com.github.skanukov.sparklet.apps.web.controllers;

import com.github.skanukov.sparklet.core.controller.SparkletController;
import com.github.skanukov.sparklet.lib.models.User;
import spark.Request;
import spark.Response;

import java.util.List;

public class UserController extends SparkletController {
    public String actionIndex(Request request, Response response) {
        List<User> users = User.getAll();
        return renderJson(response, users);
    }
}
