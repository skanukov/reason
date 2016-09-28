package com.github.skanukov.sparklet.lib.models;

import org.sql2o.Query;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * User models.
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

    public static Query fillColumnMappings(Query query) {
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
