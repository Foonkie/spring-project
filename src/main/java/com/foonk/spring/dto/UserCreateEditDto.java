package com.foonk.spring.dto;

import com.foonk.spring.database.entity.Role;
import com.foonk.spring.validation.UserInfo;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo
public class UserCreateEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;


    String firstname;

    String lastname;

    Role role;

    Integer companyId;

    MultipartFile image;
}
