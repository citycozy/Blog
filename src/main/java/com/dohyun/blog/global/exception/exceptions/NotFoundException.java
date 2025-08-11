package com.dohyun.blog.global.exception.exceptions;

import com.dohyun.blog.global.exception.msg.NotFoundMsg;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {
    public NotFoundException(NotFoundMsg msg) {
        super(msg.getMsg(), HttpStatus.NOT_FOUND);
    }
}
