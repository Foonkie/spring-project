package com.foonk.spring.listner.entity;

import lombok.Getter;

import java.util.EventObject;

@Getter
public class EntityEvent extends EventObject {

    private final AccessType accessType;

    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }


}