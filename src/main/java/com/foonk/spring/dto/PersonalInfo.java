package com.foonk.spring.dto;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@RequiredArgsConstructor
@Value
public class PersonalInfo {
String firstname;
String lastname;
LocalDate birthDate;
}
