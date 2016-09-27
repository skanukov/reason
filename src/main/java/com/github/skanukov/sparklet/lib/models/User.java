package com.github.skanukov.sparklet.lib.models;

import com.github.skanukov.sparklet.core.db.Sql2oFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.time.LocalDateTime;
import java.util.List;

/**
 * User models.
 */
public class User {
    private Long id;
    private String email;
    private String passwordDigest;
    private String rememberToken;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static List<User> getAll() {
        Sql2o db = Sql2oFactory.getSql2o();
        String sql = "SELECT * FROM users";

        List<User> result = null;
        try (Connection con = db.open()) {
            result = con.createQuery(sql)
                    .addColumnMapping("password_digest", "passwordDigest")
                    .addColumnMapping("remember_token", "rememberToken")
                    .addColumnMapping("created_at", "createdAt")
                    .addColumnMapping("updated_at", "updatedAt")
                    .executeAndFetch(User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
