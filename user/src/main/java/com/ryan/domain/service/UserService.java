package com.ryan.domain.service;

import com.ryan.application.dto.UserCreateDto;
import com.ryan.application.dto.UserDetailDto;
import com.ryan.domain.constant.UserStatus;
import com.ryan.domain.dao.UserDao;
import com.ryan.domain.entity.User;
import com.ryan.exception.customize.NotFoundException;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserDao userDao;

  public UserDetailDto getUser(String username) {
    User user = userDao.findUserByUsername(username)
        .orElseThrow(NotFoundException::new);
    return UserDetailDto.of(user);
  }

  public Long createUser(UserCreateDto dto) {
    User user = dto.toEntity();
    return userDao.save(user).getUserId();
  }

  public List<UserDetailDto> getUsers() {
    return userDao.findAll()
        .stream()
        .map(UserDetailDto::of)
        .toList();
  }

  public void activateUserBy(String username) {
    User user = userDao.findUserByUsername(username)
        .orElseThrow(NotFoundException::new);
    user.setStatus(UserStatus.ACTIVE);
    userDao.save(user);
  }

  public boolean validateUserId(String username, Long userId) {
    UserDetailDto userDetailDto = getUser(username);
    return Objects.equals(userDetailDto.userId(), userId);
  }
}
