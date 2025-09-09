package com.dohyun.blog.post.dto;

import com.dohyun.blog.member.entity.Member;

public record PostRequest () {

    public record Register (
            String title,
            String content,
            Boolean allowComment
            ) {}
}
