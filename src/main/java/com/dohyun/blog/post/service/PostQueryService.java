package com.dohyun.blog.post.service;

import com.dohyun.blog.post.entity.Post;
import com.dohyun.blog.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostQueryService {

    private PostRepository postRepository;

    public PostQueryService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
