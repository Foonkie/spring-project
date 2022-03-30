package com.foonk.spring;

import com.foonk.spring.config.ApplicationConfiguration;
import com.foonk.spring.database.pool.ConnectionPool;
import com.foonk.spring.database.repository.CompanyRepository;
import com.foonk.spring.database.repository.CrudRepository;
import com.foonk.spring.service.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
        }

    }

