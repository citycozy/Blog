package com.dohyun.blog.global.exception.msg;

import lombok.Getter;

@Getter
public enum BadRequestMsg {
    ;

    private final String msg;

    BadRequestMsg(String msg) {
        this.msg = msg;
    }
}
