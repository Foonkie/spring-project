package com.foonk.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
@Value
public class UserFilter {
    String firstname;
    String lastname;
    LocalDate birthDate;
        }
