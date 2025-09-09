package com.dohyun.blog.member.service;

import com.dohyun.blog.member.entity.Member;
import com.dohyun.blog.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberCommandService {

    private final MemberRepository memberRepository;

    public MemberCommandService(
            MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(Member member) {
        memberRepository.save(member);
    }
}
