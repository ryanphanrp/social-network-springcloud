package com.ryan.application.dto;

import com.ryan.domain.entity.User;

public record UserDetailDto(Long userId, String username, String email, String status, String password) {
    public static UserDetailDto of(User user) {
        return new UserDetailDto(user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getStatus().toString(),
                user.getPassword());
    }
}
