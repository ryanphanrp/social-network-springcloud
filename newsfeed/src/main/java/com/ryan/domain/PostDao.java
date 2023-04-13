package com.ryan.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostDao extends JpaRepository<Post, Long> {
    Optional<Post> findPostByPostId(Long postId);
}
