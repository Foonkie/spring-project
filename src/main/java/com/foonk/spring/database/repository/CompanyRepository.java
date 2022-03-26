package com.foonk.spring.database.repository;

import com.foonk.spring.bpp.Auditing;
import com.foonk.spring.bpp.InjectBean;
import com.foonk.spring.bpp.Transaction;
import com.foonk.spring.database.pool.ConnectionPool;
import com.foonk.spring.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
@Repository
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {
    public CompanyRepository(ConnectionPool pool1,
                             List<ConnectionPool> pools,
                           @Value("${db.pool.size}")  Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
    }


    private final ConnectionPool pool1;
    @Autowired
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method....");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method....");
    }


}
