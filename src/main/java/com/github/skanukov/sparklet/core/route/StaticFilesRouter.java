package com.github.skanukov.sparklet.core.route;

import spark.Spark;

/**
 * Class for managing static files handling.
 */
public final class StaticFilesRouter {
    private StaticFilesRouter() {
    }

    /**
     * Enables static files handling.
     */
    public static void handleStaticFiles(String staticRoot) {
        Spark.staticFiles.externalLocation(staticRoot);
    }
}
