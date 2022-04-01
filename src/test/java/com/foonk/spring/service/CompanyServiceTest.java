package com.foonk.spring.service;

import com.foonk.spring.database.repository.CrudRepository;
import com.foonk.spring.dto.CompanyReadDto;
import com.foonk.spring.entity.Company;
import com.foonk.spring.listner.entity.EntityEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    private static final Integer COMPANY_ID=1;
    @Mock
    private  ApplicationEventPublisher applicationEventPublisher;
    @Mock
    private  UserService userService;
    @Mock
    private  CrudRepository<Integer, Company> companyRepository;
    @InjectMocks
    private CompanyService companyService;
    @Test
    void findById() {
        doReturn(Optional.of(new Company(COMPANY_ID)))
                .when(companyRepository).findById(COMPANY_ID);

        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

        verify(applicationEventPublisher).publishEvent(any(EntityEvent.class));
        verifyNoMoreInteractions(applicationEventPublisher, userService);
    }
}