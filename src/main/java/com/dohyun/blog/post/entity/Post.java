package com.dohyun.blog.post.entity;

import com.dohyun.blog.common.BaseTime;
import com.dohyun.blog.member.entity.Member;
import com.dohyun.blog.post.dto.PostRequest;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "posts")
public class Post extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;
//    private String category;

    private String status;
    private Boolean allowComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    public static Post to(PostRequest.Register request, String status, Member member) {
        return Post.builder()
                .title(request.title())
                .content(request.content())
                .status(status)
                .allowComment(request.allowComment())
                .author(member)
                .build();
    }
}
