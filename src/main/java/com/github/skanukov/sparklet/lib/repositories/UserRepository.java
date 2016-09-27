package com.github.skanukov.sparklet.lib.repositories;

import com.github.skanukov.sparklet.lib.models.User;
import org.sql2o.Connection;

import java.util.List;

public final class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        return connection.createQuery(sql)
                .addColumnMapping("password_digest", "passwordDigest")
                .addColumnMapping("remember_token", "rememberToken")
                .addColumnMapping("created_at", "createdAt")
                .addColumnMapping("updated_at", "updatedAt")
                .executeAndFetch(User.class);
    }
}
