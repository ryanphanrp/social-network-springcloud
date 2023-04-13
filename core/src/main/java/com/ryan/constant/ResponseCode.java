package com.ryan.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    OK(200, "Success"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),
    BAD_REQUEST(-400, "Bad Request"),
    UNAUTHORIZED(-401, "Unauthorized"),
    FORBIDDEN(-403, "Forbidden"),
    NOT_FOUND(-404, "Resource Not found"),
    CONFLICT(-409, "Conflict"),
    INTERNAL_ERROR(-500, "Internal Server Error");
    private final Integer code;
    private final String message;
}
