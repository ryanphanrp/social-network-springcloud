package com.ryan.application.dto;

import com.ryan.domain.constant.UserStatus;

public record UserInfoDetailDto(
        Long userId,
        String username,
        String name,
        String email,
        String bio,
        Integer numPosts,
        Integer followers,
        Integer following,
        UserStatus status
) {
}
