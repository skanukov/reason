package com.github.skanukov.reason.lib.models;

import com.github.skanukov.reason.core.db.Sql2oFactory;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User model.
 */
public class User {
    private static final Map<String, String> COLUMN_MAPPINGS = createColumnMappings();

    private Long id;
    private String email;
    private String passwordDigest;
    private String rememberToken;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static List<User> all() {
        Sql2o db = Sql2oFactory.getSql2o();
        try (Connection connection = db.open()) {
            Query query = connection.createQuery("SELECT * FROM users");
            return fillColumnMappings(query).executeAndFetch(User.class);
        }
    }

    private static Query fillColumnMappings(Query query) {
        for (Map.Entry<String, String> mapping : COLUMN_MAPPINGS.entrySet()) {
            query.addColumnMapping(mapping.getKey(), mapping.getValue());
        }
        return query;
    }

    private static Map<String, String> createColumnMappings() {
        Map<String, String> columnMappings = new HashMap<>();
        columnMappings.put("password_digest", "passwordDigest");
        columnMappings.put("remember_token", "rememberToken");
        columnMappings.put("created_at", "createdAt");
        columnMappings.put("updated_at", "updatedAt");
        return Collections.unmodifiableMap(columnMappings);
    }
}
