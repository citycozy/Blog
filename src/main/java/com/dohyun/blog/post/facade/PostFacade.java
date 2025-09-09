package com.dohyun.blog.post.facade;

import com.dohyun.blog.member.entity.Member;
import com.dohyun.blog.member.service.MemberQueryService;
import com.dohyun.blog.post.dto.PostRequest;
import com.dohyun.blog.post.dto.PostResponse;
import com.dohyun.blog.post.entity.Post;
import com.dohyun.blog.post.entity.enums.PostStatus;
import com.dohyun.blog.post.service.PostCommandService;
import com.dohyun.blog.post.service.PostQueryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostFacade {

    private final PostCommandService postCommandService;
    private final PostQueryService postQueryService;
    private final MemberQueryService memberQueryService;

    public PostFacade(PostCommandService postCommandService, PostQueryService postQueryService, MemberQueryService memberQueryService) {
        this.postCommandService = postCommandService;
        this.postQueryService = postQueryService;
        this.memberQueryService = memberQueryService;
    }

    public PostResponse.Register register(PostRequest.Register request) {
        // 글을 작성한 지 3분이 지나지 않았으면 못 작성하게끔 추가해봐도 좋을 듯
        Member member= memberQueryService.getContextMember();
        Post post = Post.to(request, PostStatus.AVAILABLE.toString(), member);

        postCommandService.save(post);

        return PostResponse.Register.from(post.getTitle(), post.getContent(), post.getStatus(), post.getAllowComment(), post.getCreatedAt());
    }

    public List<PostResponse.GetPosts> getAllPosts() {
        List<Post> posts = postQueryService.getPosts();
        List<PostResponse.GetPosts> getPosts = new ArrayList<>();

        for(Post post:posts){
            Member member = post.getAuthor();
            getPosts.add(PostResponse.GetPosts.of(post.getTitle(), member.getNickname(), post.getCreatedAt()));
        }

        return getPosts;
    }

}
