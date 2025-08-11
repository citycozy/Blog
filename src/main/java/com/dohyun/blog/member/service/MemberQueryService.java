package com.dohyun.blog.member.service;

import com.dohyun.blog.global.exception.exceptions.ConflictException;
import com.dohyun.blog.global.exception.exceptions.NotFoundException;
import com.dohyun.blog.global.exception.msg.ConflictMsg;
import com.dohyun.blog.global.exception.msg.NotFoundMsg;
import com.dohyun.blog.member.entity.Member;
import com.dohyun.blog.member.repository.MemberRepository;
import com.dohyun.blog.security.userdetails.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public MemberQueryService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(
                        () -> new NotFoundException(NotFoundMsg.MEMBER));
    }

    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(
                        () -> new NotFoundException(NotFoundMsg.MEMBER));
    }

    public void validEmail(String email) {
        memberRepository.findByEmail(email).ifPresent(
                member -> {
                    throw new ConflictException(ConflictMsg.EMAIL);
                });
    }

    public void validNickname(String nickname) {
        memberRepository.findByNickname(nickname).ifPresent(
                member -> {
                    throw new ConflictException(ConflictMsg.NICKNAME);
                });
    }

    public Member getContextMember() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userDetails.getMember();
    }
}
