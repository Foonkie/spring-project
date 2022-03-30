package com.foonk.spring.database.repository;


import com.foonk.spring.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Qualifier;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    @Qualifier("pool2")
    private final ConnectionPool connectionPool;

}
