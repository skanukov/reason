package com.github.skanukov.sparklet.core.action;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.FileLoader;
import spark.ModelAndView;
import spark.template.pebble.PebbleTemplateEngine;

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
        PebbleEngine pebbleEngine = new PebbleEngine(new FileLoader());
        return new PebbleTemplateEngine(pebbleEngine).render(modelAndView);
    }
}
