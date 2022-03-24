package com.foonk.spring.database.repository;

import com.foonk.spring.bpp.InjectBean;
import com.foonk.spring.database.pool.ConnectionPool;

public class CompanyRepository {
    @InjectBean
    private ConnectionPool connectionPool;

}
