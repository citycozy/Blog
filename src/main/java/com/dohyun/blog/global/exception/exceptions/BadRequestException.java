package com.dohyun.blog.global.exception.exceptions;

import com.dohyun.blog.global.exception.msg.BadRequestMsg;
import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {
    public BadRequestException(BadRequestMsg msg) {
        super(msg.getMsg(), HttpStatus.BAD_REQUEST);
    }
}
