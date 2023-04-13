package com.ryan.domain.dao;

import com.ryan.domain.entity.pojo.UserFollowDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFollowDao {

  UserFollowDetail getUserFollowDetail(Long userId);
}
