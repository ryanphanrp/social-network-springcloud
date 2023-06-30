package com.ryan.exception;

import com.ryan.constant.ResponseCode;
import lombok.Getter;

@Getter
public class SocialMonoException extends RuntimeException {
    private final ResponseCode responseCode;

    public SocialMonoException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    public SocialMonoException(String message) {
        super(message);
        this.responseCode = ResponseCode.INTERNAL_ERROR;
    }
}
