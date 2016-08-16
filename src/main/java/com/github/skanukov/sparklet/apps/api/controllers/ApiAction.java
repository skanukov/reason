package com.github.skanukov.sparklet.apps.api.controllers;

import com.google.gson.Gson;

/**
 * Base class for the current application actions.
 */
public abstract class ApiAction {
    protected Object renderJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
