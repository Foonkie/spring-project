package com.foonk.spring.service;

import com.foonk.spring.database.repository.CrudRepository;
import com.foonk.spring.entity.Company;
import org.springframework.stereotype.Service;
import com.foonk.spring.dto.CompanyReadDto;
import java.util.Optional;

@Service
public class CompanyService {

    private final UserService userService;
    private final CrudRepository<Integer, Company> companyRepository;

    public CompanyService(UserService userService, CrudRepository<Integer, Company> companyRepository) {
        this.userService = userService;
        this.companyRepository = companyRepository;
    }
    public Optional<CompanyReadDto> findById(Integer id){
        companyRepository.findById(id)
                .map(entity->new CompanyRea
    }
}
