package com.foonk.spring.listner.entity;

import java.util.EventObject;


public class EntityEvent extends EventObject {

    private final AccessType accessType;

    public EntityEvent(Object source, AccessType accessType) {
        super(source);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}