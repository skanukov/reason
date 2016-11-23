package com.github.skanukov.sparklet.core.route;

/**
 * Base interface for mounting application routers.
 */
@FunctionalInterface
public interface IDispatcher {
    /**
     * Dispatches application routers.
     */
    void dispatch();
}
