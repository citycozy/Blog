package com.dohyun.blog.member.dto.request;

public record MemberRequest() {

    public record Signup(String email, String nickname, String password, String role) {}
}
