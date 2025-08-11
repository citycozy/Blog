package com.dohyun.blog.global.exception.msg;

import lombok.Getter;

@Getter
public enum UnauthorizedMsg {
    AUTHENTICATION_REQUIRED("인증이 필요합니다"),
    INVALID_EMAIL_PASSWORD("올바르지 않은 이메일 또는 패스워드 입니다.");

    private final String msg;

    UnauthorizedMsg(String msg) {
        this.msg = msg;
    }
}
