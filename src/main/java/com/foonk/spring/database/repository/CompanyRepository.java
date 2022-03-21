package com.foonk.spring.database.repository;

import com.foonk.spring.database.rpool.ConnectionPool;

public class CompanyRepository {
    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    private final ConnectionPool connectionPool;
}
