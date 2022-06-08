package com.foonk.spring.aop;

import com.foonk.spring.validation.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Aspect
@Component
public class FirstAspect {

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer(){
    }

    @Pointcut("within(com.foonk.spring.service.*Service)")
    public void isServiceLayer(){
    }

    @Pointcut("this(org.springframework.stereotype.Repository)")
    public void isRepositoryLayer(){
    }

    @Pointcut("isControllerLayer()&&@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping(){
    }

    @Pointcut("isControllerLayer()&&args(org.springframework.ui.Model,..)")
    public void hasModelParam(){
    }

    @Pointcut("isControllerLayer()&&@args(com.foonk.spring.validation.UserInfo,...)")
    public void hasUserInfoParamAnnotation(){
    }

    @Pointcut("bean(*Service)")
    public void isServiceLayerBean(){
    }

    @Pointcut("execution(public * com.foonk.spring.service.*Service.findById(*))")
    public void anyFindByIdServiceMethod(){
    }

    @Before("anyFindByIdServiceMethod()")
    public void addLogging(JoinPoint joinPoint){
        log.info("invoked findById method");
    }
}
