package com.dohyun.blog.member.service;

import com.dohyun.blog.member.dto.request.MemberRequest;
import com.dohyun.blog.member.entity.Member;
import com.dohyun.blog.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberCommandService {

    private final MemberRepository memberRepository;
    private final MemberQueryService memberQueryService;
    private final PasswordEncoder passwordEncoder;

    public MemberCommandService(
            MemberRepository memberRepository,
            MemberQueryService memberQueryService,
            PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.memberQueryService = memberQueryService;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(MemberRequest.Signup request) {
        memberQueryService.validNickname(request.nickname());
        memberQueryService.validEmail(request.email());

        memberRepository.save(Member.to(request, passwordEncoder));
    }
}
