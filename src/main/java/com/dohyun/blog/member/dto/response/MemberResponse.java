package com.dohyun.blog.member.dto.response;

import com.dohyun.blog.member.dto.request.MemberRequest;

public record MemberResponse() {

    public record Signup(String email, String nickname, String role) {
        public static Signup from(MemberRequest.Signup request) {
            return new Signup(request.email(), request.nickname(), request.role());
        }
    }

    public record GetMember(Long memberId, String email, String nickname, String role) {
        public static GetMember of(Long memberId, String email, String nickname, String role) {
            return new GetMember(memberId, email, nickname, role);
        }
    }
}
