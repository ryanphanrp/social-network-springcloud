package com.ryan.application.dto;

import com.ryan.domain.entity.User;

public record UserDto(Long userId, String username) {
    public static UserDto of(User user) {
        return new UserDto(user.getUserId(), user.getUsername());
    }
}
