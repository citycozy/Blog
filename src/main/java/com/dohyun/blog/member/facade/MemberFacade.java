package com.dohyun.blog.member.facade;

import com.dohyun.blog.member.dto.request.MemberRequest;
import com.dohyun.blog.member.dto.response.MemberResponse;
import com.dohyun.blog.member.entity.Member;
import com.dohyun.blog.member.service.MemberCommandService;
import com.dohyun.blog.member.service.MemberQueryService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberFacade {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final PasswordEncoder encoder;

    public MemberFacade(
            MemberCommandService memberCommandService,
            MemberQueryService memberQueryService,
            PasswordEncoder encoder) {
        this.memberCommandService = memberCommandService;
        this.memberQueryService = memberQueryService;
        this.encoder = encoder;
    }

    public MemberResponse.Signup signup(MemberRequest.Signup request) {
        memberQueryService.existsByEmail(request.email());
        memberQueryService.existsByNickname(request.nickname());
        memberCommandService.save(Member.to(request, encoder));
        return MemberResponse.Signup.from(request);
    }

    public MemberResponse.GetMember getLoginMember() {
        Member member = memberQueryService.getContextMember();

        return MemberResponse.GetMember.of(
                member.getId(), member.getEmail(), member.getNickname(), member.getRole());
    }
}
