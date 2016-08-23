package com.github.skanukov.sparklet.core.template;

import com.github.skanukov.sparklet.Application;
import freemarker.template.Configuration;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.File;
import java.io.IOException;

/**
 * Creates the template engine.
 */
public final class FreeMarkerTemplateEngine {
    private FreeMarkerTemplateEngine() {
    }

    /**
     * Creates the template engine.
     *
     * @return The template engine.
     */
    public static TemplateEngine createTemplateEngine() {
        File currentWorkingDir = new File(System.getProperty("user.dir"));
        Configuration templateEngineConfig = new Configuration();
        try {
            templateEngineConfig.setDirectoryForTemplateLoading(currentWorkingDir);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        if (Application.getInstance().getSettings().isDebug()) {
            templateEngineConfig.setTemplateUpdateDelay(0);
        }
        return new FreeMarkerEngine(templateEngineConfig);
    }
}
