package com.dohyun.blog.member.entity;

import com.dohyun.blog.common.BaseTime;
import com.dohyun.blog.member.dto.request.MemberRequest;
import com.dohyun.blog.post.entity.Post;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "members")
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String nickname;
    private String role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

    public static Member to(MemberRequest.Signup request, PasswordEncoder encoder) {
        return Member.builder()
                .nickname(request.nickname())
                .email(request.email())
                .password(encoder.encode(request.password()))
                .role(request.role())
                .build();
    }

}
