package com.ryan.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ryan.domain.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static com.ryan.utils.DatetimeUtils.unixTimeOf;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PostDto(
        Long postId,
        String content,
        UserDto user,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
    public static PostDto of(Post post) {
        return new PostDto(
                post.getPostId(),
                post.getContent(),
                UserDto.of(post.getUser()),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    public Long getCreatedAt() {
        return unixTimeOf(createdAt);
    }

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    public Long getUpdatedAt() {
        return unixTimeOf(updatedAt);
    }
}
