package com.github.skanukov.sparklet.apps.api.controllers.home;

import com.github.skanukov.sparklet.core.action.JsonAction;
import com.github.skanukov.sparklet.core.json.JsonEngineFactory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

/**
 * Home controller IndexAction action.
 */
public class IndexAction extends HomeAction implements JsonAction {
    /**
     * Handles the http request.
     *
     * @param req The http request.
     * @param res The http request.
     * @return HttpAction result.
     */
    @Override
    public Object call(Request req, Response res) {
        JsonObject appSettings = new JsonObject();
        appSettings.addProperty("debug", "true");
        JsonObject dbSettings = new JsonObject();
        dbSettings.addProperty("host", "localhost");
        dbSettings.addProperty("port", 4567);
        appSettings.add("db", dbSettings);

        Gson gson = JsonEngineFactory.getJsonEngine();
        JsonObject readAppSettings = gson.fromJson(appSettings, JsonObject.class);
        int port = readAppSettings.getAsJsonObject("db").get("port").getAsInt();
        return renderJson(res, appSettings);
    }
}
