package com.dohyun.blog.global.exception.msg;

import lombok.Getter;

@Getter
public enum ConflictMsg {
    EMAIL("이미 사용중인 이메일입니다."),
    NICKNAME("이미 사용중인 닉네임입니다.");

    private final String msg;

    ConflictMsg(String msg) {
        this.msg = msg;
    }
}
