package com.github.skanukov.reason.core.db;

import org.sql2o.Sql2o;

/**
 * Holds the Sql2o query engine.
 */
public final class Sql2oFactory {
    private Sql2oFactory() {
    }

    // Lazy initialization
    private static class Sql2oHolder {
        private static final Sql2o INSTANCE = createSql2o();
    }

    /**
     * Returns the application Sql2o instance.
     *
     * @return The application Sql2o instance.
     */
    public static Sql2o getSql2o() {
        return Sql2oHolder.INSTANCE;
    }

    /**
     * Creates the Sql2o instance.
     *
     * @return The Sql2o instance.
     */
    private static Sql2o createSql2o() {
        // Use HikariCP for Sql2o
        return new Sql2o(HikariDataSourceFactory.getHikariDataSource());
    }
}
