package com.foonk.spring.validation.impl;

import com.foonk.spring.dto.UserCreateEditDto;
import com.foonk.spring.validation.UserInfo;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserinfoValidator implements ConstraintValidator <UserInfo, UserCreateEditDto> {

    @Override
    public boolean isValid(UserCreateEditDto value, ConstraintValidatorContext context) {
        return StringUtils.hasText(value.getFirstname())||StringUtils.hasText(value.getLastname());
    }
}
