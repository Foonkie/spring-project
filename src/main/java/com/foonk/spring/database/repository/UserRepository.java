package com.foonk.spring.database.repository;


import com.foonk.spring.database.pool.ConnectionPool;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Qualifier;

@Repository

public class UserRepository {
    private final ConnectionPool connectionPool;
    public UserRepository(@Qualifier("pool2") ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
