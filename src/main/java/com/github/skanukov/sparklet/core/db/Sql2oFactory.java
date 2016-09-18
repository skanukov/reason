package com.github.skanukov.sparklet.core.db;

import com.github.skanukov.sparklet.core.config.SettingsFactory;
import com.google.gson.JsonObject;
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
        JsonObject dbSettings = SettingsFactory.getSettings().getAsJsonObject("db");
        String host = dbSettings.get("host").getAsString();
        int port = dbSettings.get("port").getAsInt();
        String database = dbSettings.get("database").getAsString();
        String user = dbSettings.get("user").getAsString();
        String password = dbSettings.get("password").getAsString();
        String connectionString = String.format("jdbc:postgresql://%s:%d/%s", host, port, database);
        return new Sql2o(connectionString, user, password);
    }
}
