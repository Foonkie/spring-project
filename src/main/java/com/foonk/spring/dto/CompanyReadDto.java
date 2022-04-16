package com.foonk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
@AllArgsConstructor
@Value
public class CompanyReadDto {
    Integer id;
    String name;
}
