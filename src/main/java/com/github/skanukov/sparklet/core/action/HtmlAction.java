package com.github.skanukov.sparklet.core.action;

import com.github.skanukov.sparklet.core.template.TemplateEngineFactory;
import spark.ModelAndView;

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
        return TemplateEngineFactory.getTemplateEngine().render(modelAndView);
    }
}
