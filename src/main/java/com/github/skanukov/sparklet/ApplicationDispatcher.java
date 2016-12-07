package com.github.skanukov.sparklet;

import com.github.skanukov.sparklet.apps.web.WebRouter;
import com.github.skanukov.sparklet.core.settings.SettingsFactory;
import com.github.skanukov.sparklet.core.route.IDispatcher;
import com.github.skanukov.sparklet.core.route.StaticFilesRouter;
import com.google.gson.JsonObject;

/**
 * Handles all routes for applications.
 */
public final class ApplicationDispatcher implements IDispatcher {
    /**
     * Defines mount points for applications.
     */
    @Override
    public void dispatch() {
        // Handle static files for development mode.
        JsonObject settings = SettingsFactory.getSettings();
        if (settings.get("isDebug").getAsBoolean()) {
            StaticFilesRouter.handleStaticFiles(settings.get("staticRoot").getAsString());
        }

        new WebRouter().route();
    }
}
