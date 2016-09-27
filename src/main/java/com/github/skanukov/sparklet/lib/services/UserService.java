package com.github.skanukov.sparklet.lib.services;

import com.github.skanukov.sparklet.core.db.Sql2oFactory;
import com.github.skanukov.sparklet.lib.models.User;
import com.github.skanukov.sparklet.lib.repositories.UserRepository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public final class UserService {
    public List<User> getAllUsers() {
        List<User> result;

        Sql2o db = Sql2oFactory.getSql2o();
        try (Connection con = db.open()) {
            result = new UserRepository(con).getAll();
        }

        return result;
    }
}
