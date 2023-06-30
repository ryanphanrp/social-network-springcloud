package com.ryan.domain.service;

import com.ryan.application.dto.UserInfoCreateDto;
import com.ryan.constant.ResponseCode;
import com.ryan.domain.dao.UserDetailDao;
import com.ryan.domain.dao.UserInfoDao;
import com.ryan.domain.entity.UserInfo;
import com.ryan.domain.entity.pojo.UserDetail;
import com.ryan.exception.SocialMonoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

  private final UserInfoDao userInfoDao;
  private final UserDetailDao userDetailDao;
  private final UserService userService;

  public Long createUserInfo(String username, UserInfoCreateDto dto) {
    // TODO: need to validate by Spring Security
      if (!userService.validateUserId(username, dto.userId())) {
          throw new SocialMonoException(ResponseCode.FORBIDDEN);
      }
    UserInfo userInfo = dto.toEntity();
    return userInfoDao.save(userInfo).getUserInfoId();
  }

  public UserDetail getUserInfoDetail(String username) {
    return userDetailDao.findUserInfoByUsername(username)
        .orElseThrow(() -> new SocialMonoException(ResponseCode.NOT_FOUND));
  }
}
