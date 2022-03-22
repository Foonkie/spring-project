package com.foonk.spring.service;

import com.foonk.spring.database.repository.CompanyRepository;
import com.foonk.spring.database.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private CompanyService companyService;

    public UserService(UserRepository userRepository,
                       CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}
