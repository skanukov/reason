package com.github.skanukov.sparklet;

import com.github.skanukov.sparklet.apps.web.WebRouter;
import com.github.skanukov.sparklet.core.settings.SettingsFactory;
import com.github.skanukov.sparklet.core.route.IDispatcher;
import com.github.skanukov.sparklet.core.route.StaticFilesRouter;

/**
 * Handles all routes for applications.
 */
public final class ApplicationDispatcher implements IDispatcher {
    /**
     * Defines mount points for applications.
     */
    @Override
    public void dispatch() {
        // Handle static files for development mode
        if (SettingsFactory.getSettings().get("isDebug").getAsBoolean()) {
            StaticFilesRouter.handleStaticFiles();
        }

        new WebRouter().route();
    }
}
