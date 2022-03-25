package com.foonk.spring.database.repository;

import com.foonk.spring.bpp.Auditing;
import com.foonk.spring.bpp.InjectBean;
import com.foonk.spring.bpp.Transaction;
import com.foonk.spring.database.pool.ConnectionPool;
import com.foonk.spring.entity.Company;

import javax.annotation.PostConstruct;
import java.util.Optional;
@Auditing
@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company> {
    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    private void init(){
        System.out.println("init company repository");
    }
    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}
