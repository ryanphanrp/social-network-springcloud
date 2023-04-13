package com.ryan.exception;

import com.ryan.constant.ResponseCode;
import com.ryan.dto.ResponseDto;
import com.ryan.exception.customize.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalAppExceptionHandler {

    @ExceptionHandler({GlobalAppException.class})
    @ResponseStatus(HttpStatus.GONE)
    @ResponseBody
    public ResponseDto<Object> globalAppHandler(HttpServletRequest req, GlobalAppException exp) {
        log.error("[GlobalAppException]: {} - {}", req.getRequestURI(), exp.getMessage());
        return ResponseDto.error(exp.getResponseCode());
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    public ResponseDto<Object> handleNotFount(HttpServletRequest req, NotFoundException exp) {
        log.error("[NotFoundException]: {} - {}", req.getRequestURI(), exp.getMessage());
        return ResponseDto.error(exp.getResponseCode());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseDto<Object> handleUncaughtException(Exception exp) {
        log.error("[InternalServerException]: {}", exp.getMessage());
        return ResponseDto.error(ResponseCode.INTERNAL_ERROR, exp.getMessage());
    }
}
