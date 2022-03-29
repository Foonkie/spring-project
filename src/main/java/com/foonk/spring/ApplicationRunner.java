package com.foonk.spring;

import com.foonk.spring.config.ApplicationConfiguration;
import com.foonk.spring.database.pool.ConnectionPool;
import com.foonk.spring.database.repository.CompanyRepository;
import com.foonk.spring.database.repository.CrudRepository;
import com.foonk.spring.service.CompanyService;
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
            var companyService = context.getBean("companyService", CompanyService.class);
            System.out.println(companyService.findById(1));
        }

    }
}
