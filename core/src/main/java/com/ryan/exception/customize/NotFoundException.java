package com.ryan.exception.customize;

import com.ryan.constant.ResponseCode;
import com.ryan.exception.SocialMonoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends SocialMonoException {
  public NotFoundException() {
    super(ResponseCode.NOT_FOUND);
  }
}
