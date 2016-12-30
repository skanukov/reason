package com.github.skanukov.reason.core.route;

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
