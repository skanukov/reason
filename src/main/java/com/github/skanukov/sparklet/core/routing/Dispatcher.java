package com.github.skanukov.sparklet.core.routing;

/**
 * Base class for mounting application routers.
 */
public interface Dispatcher {
    /**
     * Dispatches
     * @return
     */
    Dispatcher dispatch();
}
