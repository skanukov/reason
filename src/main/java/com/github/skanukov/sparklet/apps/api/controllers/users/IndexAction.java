package com.github.skanukov.sparklet.apps.api.controllers.users;

import com.github.skanukov.sparklet.core.action.JsonAction;
import com.github.skanukov.sparklet.lib.model.User;
import spark.Request;
import spark.Response;

import java.util.List;

public class IndexAction extends UsersAction implements JsonAction {
    @Override
    public Object call(Request req, Response res) {
        List<User> users = User.getAll();
        return renderJson(res, users);
    }
}
