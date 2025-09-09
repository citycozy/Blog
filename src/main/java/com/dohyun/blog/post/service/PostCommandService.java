package com.dohyun.blog.post.service;

import com.dohyun.blog.post.entity.Post;
import com.dohyun.blog.post.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostCommandService {

    private PostRepository postRepository;

    public PostCommandService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        postRepository.save(post);
    }
}
