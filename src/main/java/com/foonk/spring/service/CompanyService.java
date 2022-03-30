package com.foonk.spring.service;

import com.foonk.spring.database.repository.CrudRepository;
import com.foonk.spring.entity.Company;
import com.foonk.spring.listner.entity.AccessType;
import com.foonk.spring.listner.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import com.foonk.spring.dto.CompanyReadDto;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserService userService;
    private final CrudRepository<Integer, Company> companyRepository;


    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                .map(entity->{
                       applicationEventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                return new CompanyReadDto(entity.getId());
                });
    }
}
