package com.dohyun.blog.security.userdetails;

import com.dohyun.blog.global.exception.msg.NotFoundMsg;
import com.dohyun.blog.member.entity.Member;
import com.dohyun.blog.member.repository.MemberRepository;
import com.dohyun.blog.member.service.MemberQueryService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    public UserDetailsServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findByEmail(email);

        return member.map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException(NotFoundMsg.EMAIL.getMsg()));
    }


}
