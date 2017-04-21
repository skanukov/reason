package com.github.skanukov.reason.core.db;

import com.github.skanukov.reason.core.settings.SettingsFactory;
import com.google.gson.JsonObject;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Provides a Hikari data source.
 */
public class HikariDataSourceFactory {
    private HikariDataSourceFactory() {
    }

    // Lazy initialization.
    private static class DataSourceHolder {
        private static final HikariDataSource INSTANCE = createHikariDataSource();
    }

    public static HikariDataSource getHikariDataSource() {
        return DataSourceHolder.INSTANCE;
    }

    private static HikariDataSource createHikariDataSource() {
        // Get db connection settings.
        JsonObject dbSettings = SettingsFactory.getSettings().getAsJsonObject("db");

        String host = dbSettings.get("host").getAsString();
        int port = dbSettings.get("port").getAsInt();
        String database = dbSettings.get("database").getAsString();
        String username = dbSettings.get("username").getAsString();
        String password = dbSettings.get("password").getAsString();
        String connectionString = String.format("jdbc:postgresql://%s:%d/%s", host, port, database);
        int maxPoolSize = dbSettings.get("maxPoolSize").getAsInt();

        // Config HikariCP.
        HikariConfig config = HikariDataSourceFactory.buildConfig(connectionString, username,
                password, maxPoolSize);
        return HikariDataSourceFactory.buildDataSource(config);
    }

    private static HikariConfig buildConfig(String connectionString, String username,
                                            String password, int maxPoolSize) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(connectionString);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(maxPoolSize);
        return config;
    }

    private static HikariDataSource buildDataSource(HikariConfig config) {
        return new HikariDataSource(config);
    }
}

