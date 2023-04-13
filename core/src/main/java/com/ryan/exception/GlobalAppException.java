package com.ryan.exception;

import com.ryan.constant.ResponseCode;
import lombok.Getter;

@Getter
public class GlobalAppException extends RuntimeException {
    private final ResponseCode responseCode;

    public GlobalAppException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }
}
