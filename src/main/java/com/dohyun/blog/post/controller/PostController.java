package com.dohyun.blog.post.controller;

import com.dohyun.blog.global.response.ApiResponse;
import com.dohyun.blog.post.dto.PostRequest;
import com.dohyun.blog.post.dto.PostResponse;
import com.dohyun.blog.post.facade.PostFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostFacade  postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponse.Register>> createPost(@RequestBody PostRequest.Register request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.create(postFacade.register(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostResponse.GetPosts>>> getPosts() {
        return ResponseEntity.ok(ApiResponse.success(postFacade.getAllPosts()));
    }
}

