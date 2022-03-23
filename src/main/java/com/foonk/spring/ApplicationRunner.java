package com.foonk.spring;

import com.foonk.spring.database.pool.ConnectionPool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            System.out.println(context.getBean("p1", ConnectionPool.class));
        }

    }
}
