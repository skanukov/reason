package com.github.skanukov.reason.lib.repositories;

import com.github.skanukov.reason.lib.models.User;
import org.sql2o.Connection;
import org.sql2o.Query;

import java.util.List;

public final class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAll() {
        Query query = connection.createQuery("SELECT * FROM users");
        return User.fillColumnMappings(query).executeAndFetch(User.class);
    }
}
