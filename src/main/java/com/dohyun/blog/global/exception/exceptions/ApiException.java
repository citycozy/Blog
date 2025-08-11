package com.dohyun.blog.global.exception.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {

    private final HttpStatus status;

    public ApiException(final String msg, HttpStatus status) {
        super(msg);
        this.status = status;
    }
}
