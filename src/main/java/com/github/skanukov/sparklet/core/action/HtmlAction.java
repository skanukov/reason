package com.github.skanukov.sparklet.core.action;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.File;
import java.io.IOException;

/**
 * Defines interface for applications actions rendering HTML templates.
 */
@FunctionalInterface
public interface HtmlAction extends HttpAction {
    /**
     * Renders HTML template to the response.
     *
     * @param modelAndView The data containing model and template path.
     * @return The rendered HTML template.
     */
    default String renderTemplate(ModelAndView modelAndView) {
        final Configuration templateEngineConfig = new Configuration();
        try {
            templateEngineConfig.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return new FreeMarkerEngine(templateEngineConfig).render(modelAndView);
    }
}
