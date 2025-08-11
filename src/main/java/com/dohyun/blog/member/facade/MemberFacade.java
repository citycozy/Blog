package com.dohyun.blog.member.facade;

import com.dohyun.blog.member.dto.request.MemberRequest;
import com.dohyun.blog.member.dto.response.MemberResponse;
import com.dohyun.blog.member.entity.Member;
import com.dohyun.blog.member.service.MemberCommandService;
import com.dohyun.blog.member.service.MemberQueryService;
import org.springframework.stereotype.Service;

@Service
public class MemberFacade {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    public MemberFacade(
            MemberCommandService memberCommandService, MemberQueryService memberQueryService) {
        this.memberCommandService = memberCommandService;
        this.memberQueryService = memberQueryService;
    }

    public MemberResponse.Signup signup(MemberRequest.Signup request) {
        memberCommandService.signup(request);

        return MemberResponse.Signup.from(request);
    }

    public MemberResponse.GetMember getLoginMember() {
        Member member = memberQueryService.getContextMember();

        return MemberResponse.GetMember.of(
                member.getId(), member.getEmail(), member.getNickname(), member.getRole());
    }
}
