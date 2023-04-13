package com.ryan.domain.dao;

import com.ryan.domain.entity.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFollowRepository extends JpaRepository<UserFollow, Long> {

  Long countUserFollowsByFromUserId(Long userId);

  Long countUserFollowsByToUserId(Long userId);
}
