package com.foonk.spring.database.repository;

import com.foonk.spring.database.entity.Role;
import com.foonk.spring.database.entity.User;
import com.foonk.spring.dto.PersonalInfo;
import com.foonk.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);
}
