package com.github.skanukov.sparklet.apps.web.controllers;

import com.github.skanukov.sparklet.Application;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.FileLoader;
import spark.ModelAndView;
import spark.template.pebble.PebbleTemplateEngine;

/**
 * Base class for the current application actions.
 */
public abstract class WebAction {
    protected String renderTemplate(ModelAndView modelAndView) {
        PebbleEngine pebbleEngine = new PebbleEngine(new FileLoader());
        if (Application.getInstance().getSettings().isDebug()) {
            pebbleEngine.setTemplateCache(null);
        }
        return new PebbleTemplateEngine(pebbleEngine).render(modelAndView);
    }
}
