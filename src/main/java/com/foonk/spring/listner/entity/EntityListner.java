package com.foonk.spring.listner.entity;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListner {

    @EventListener
    public void acceptEntity(EntityEvent entityEvent) {
        System.out.println("Entity: " + entityEvent);
    }
}