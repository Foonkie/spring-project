package com.foonk.spring.database.repository;

import com.foonk.spring.database.entity.User;
import com.foonk.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
