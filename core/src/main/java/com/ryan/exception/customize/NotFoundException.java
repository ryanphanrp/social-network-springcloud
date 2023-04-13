package com.ryan.exception.customize;

import com.ryan.constant.ResponseCode;
import com.ryan.exception.GlobalAppException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends GlobalAppException {
  public NotFoundException() {
    super(ResponseCode.NOT_FOUND);
  }
}
