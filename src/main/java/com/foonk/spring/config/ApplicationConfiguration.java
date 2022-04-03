package com.foonk.spring.config;

import com.foonk.spring.database.pool.ConnectionPool;
import com.foonk.spring.database.repository.CrudRepository;
import com.foonk.spring.database.repository.UserRepository;
import com.foonk.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ComponentScan.*;
//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration

public class ApplicationConfiguration {
    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 20);
    }
    @Bean
    @Profile("prod")
    public UserRepository userRepository2(ConnectionPool pool2) {
        return new UserRepository(pool2);
    }
}
