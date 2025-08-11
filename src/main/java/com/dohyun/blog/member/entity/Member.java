package com.dohyun.blog.member.entity;

import com.dohyun.blog.member.dto.request.MemberRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class  Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String nickname;
    private String role;

    public static Member to(MemberRequest.Signup request, PasswordEncoder encoder) {
        return Member.builder()
                .nickname(request.nickname())
                .email(request.email())
                .password(encoder.encode(request.password()))
                .role(request.role())
                .build();
    }
}
