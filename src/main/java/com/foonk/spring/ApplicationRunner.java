package com.foonk.spring;

import com.foonk.spring.config.ApplicationConfiguration;
import com.foonk.spring.database.pool.ConnectionPool;
import com.foonk.spring.database.repository.CompanyRepository;
import com.foonk.spring.database.repository.CrudRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext();) {
            context.register(ApplicationConfiguration.class);
            context.getEnvironment().setActiveProfiles("web", "prod");
            context.refresh();
            //  clazz -> String -> Map<String, Object>
            var connectionPool = context.getBean("p1", ConnectionPool.class);
            System.out.println(connectionPool);
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }

    }
}
