package com.dohyun.blog.global.exception.msg;

import lombok.Getter;

@Getter
public enum NotFoundMsg {
    MEMBER("존재하지 않는 회원입니다."),
    ;

    private final String msg;

    NotFoundMsg(String msg) {
        this.msg = msg;
    }
}
