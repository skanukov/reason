package com.github.skanukov.reason.apps.web.controllers;

import com.github.skanukov.reason.core.controller.ApplicationController;
import com.github.skanukov.reason.lib.models.User;
import com.github.skanukov.reason.lib.services.UserService;
import spark.Request;
import spark.Response;

import java.util.List;

public class UserController extends ApplicationController {
    public String actionIndex(Request request, Response response) {
        List<User> users = new UserService().getAllUsers();
        return renderJson(response, users);
    }
}
