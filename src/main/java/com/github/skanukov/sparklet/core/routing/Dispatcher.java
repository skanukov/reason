package com.github.skanukov.sparklet.core.routing;

/**
 * Base class for mounting application routers.
 */
public interface Dispatcher {
    /**
     * Dispatches application routers.
     * @return The Dispatcher instance for fluent interface.
     */
    Dispatcher dispatch();
}
