package com.dohyun.blog.global.exception.exceptions;

import com.dohyun.blog.global.exception.msg.UnauthorizedMsg;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApiException {

    public UnauthorizedException(UnauthorizedMsg msg) {
        super(msg.getMsg(), HttpStatus.UNAUTHORIZED);
    }
}
