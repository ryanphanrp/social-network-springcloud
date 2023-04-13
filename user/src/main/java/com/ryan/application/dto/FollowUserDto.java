package com.ryan.application.dto;

import com.ryan.constant.ResponseCode;
import com.ryan.exception.GlobalAppException;
import java.util.Objects;

public record FollowUserDto(Long from, Long to) {

  public FollowUserDto {
    // TODO: check current user with user need to follow
    if (Objects.equals(from, to)) {
      throw new GlobalAppException(ResponseCode.FORBIDDEN);
    }
  }
}
