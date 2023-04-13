package com.ryan.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record PostDetailDto(
        Long postId,
        String content,
        Long createdAt,
        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        Long updatedAt,
        UserDetailDto user
) {
    public static PostDetailDto of(PostDto post, UserDetailDto userDetail) {
        return new PostDetailDto(
                post.postId(),
                post.content(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                userDetail);
    }
}
