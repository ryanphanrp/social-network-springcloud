package com.ryan.domain.dao;

import com.ryan.domain.entity.pojo.UserDetail;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailDao extends JpaRepository<UserDetail, Long> {

  @Query(value = "select * from user_infos u join users usr using (user_id) where usr.username = :username", nativeQuery = true)
  Optional<UserDetail> findUserInfoByUsername(String username);
}
