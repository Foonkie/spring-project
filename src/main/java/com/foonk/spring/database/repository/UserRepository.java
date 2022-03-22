package com.foonk.spring.database.repository;


import com.foonk.spring.database.pool.ConnectionPool;

public class UserRepository {
    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    private final ConnectionPool connectionPool;
}
