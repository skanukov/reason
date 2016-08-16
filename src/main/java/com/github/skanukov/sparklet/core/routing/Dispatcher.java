package com.github.skanukov.sparklet.core.routing;

/**
 * Base class for mounting application routers.
 */
@FunctionalInterface
public interface Dispatcher {
    /**
     * Dispatches application routers.
     */
    void dispatch();
}
