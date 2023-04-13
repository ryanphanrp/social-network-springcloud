package com.ryan.application.dto;

import com.ryan.domain.entity.UserInfo;

public record UserInfoCreateDto(Long userId, String bio, String name) {
    public UserInfo toEntity() {
        return UserInfo.builder()
                .userId(userId)
                .bio(bio)
                .name(name)
                .numPosts(0)
                .followers(0)
                .following(0)
                .build();
    }
}
