package com.foonk.spring.dto;

import com.foonk.spring.database.entity.Role;
import com.foonk.spring.validation.UserInfo;
import com.foonk.spring.validation.group.CreateAction;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.postgresql.util.LruCache;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo
public class UserCreateEditDto {
    @Email
    String username;

    @NotBlank(groups = CreateAction.class)
    String rawPassword;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;


    String firstname;

    String lastname;

    Role role;

    Integer companyId;

    MultipartFile image;
}
