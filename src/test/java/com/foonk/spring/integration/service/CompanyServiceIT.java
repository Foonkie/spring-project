package com.foonk.spring.integration.service;

import com.foonk.spring.config.DatabaseProperties;
import com.foonk.spring.database.repository.CompanyRepository;
import com.foonk.spring.dto.CompanyReadDto;
import com.foonk.spring.integration.annotation.IT;
import com.foonk.spring.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class, initializers = ConfigDataApplicationContextInitializer.class)
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    private  CompanyService companyService;
    private  DatabaseProperties databaseProperties;
    private final CompanyRepository companyRepository;

    @Test
    void checkFindByQueries() {
        companyRepository.findByName("google");
        companyRepository.findAllByNameContainingIgnoreCase("a");
    }
    @Test
    void findById() {
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}