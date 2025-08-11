package com.dohyun.blog.global.exception.exceptions;

import com.dohyun.blog.global.exception.msg.ConflictMsg;
import org.springframework.http.HttpStatus;

public class ConflictException extends ApiException {

    public ConflictException(ConflictMsg msg) {
        super(msg.getMsg(), HttpStatus.CONFLICT);
    }
}
