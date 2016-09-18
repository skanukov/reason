package com.github.skanukov.sparklet.lib.model;

/**
 * Role enum.
 */
public enum Role {
    user("user"), admin("admin");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return role;
    }
}
