package com.ryan.application.dto;

import com.ryan.constant.ResponseCode;
import com.ryan.domain.entity.User;
import com.ryan.exception.GlobalAppException;
import com.ryan.infrastructure.UsernameValidator;

import static com.ryan.utils.PasswordUtils.generatePassword;

public record UserCreateDto(String username, String email) {
    public User toEntity() {
        // TODO: must be use annotation in Spring Constraint Validation
        if (!UsernameValidator.isValid(username)) throw new GlobalAppException(ResponseCode.BAD_REQUEST);
        return User.builder()
                .withUsername(username)
                .withEmail(email)
                .withPassword(generatePassword())
                .build();
    }
}
