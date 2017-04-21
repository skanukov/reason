package com.github.skanukov.reason.apps.web.controllers;

import com.github.skanukov.reason.core.controller.ApplicationController;
import com.github.skanukov.reason.lib.models.User;
import spark.Request;
import spark.Response;

import java.util.List;

public class UserController extends ApplicationController {
    public String actionIndex(Request request, Response response) {
        List<User> users = User.all();
        return renderJson(response, users);
    }
}
