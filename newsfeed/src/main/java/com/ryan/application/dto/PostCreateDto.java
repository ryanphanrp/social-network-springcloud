package com.ryan.application.dto;

import com.ryan.domain.Post;
import com.ryan.domain.entity.User;

public record PostCreateDto(String content, Long userId) {
    public Post toEntity() {
        return Post.builder()
                .withContent(content)
                .withUser(User.builder().withUserId(userId).build())
                .build();
    }
}
