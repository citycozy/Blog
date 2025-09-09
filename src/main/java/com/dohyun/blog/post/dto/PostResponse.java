package com.dohyun.blog.post.dto;

import com.dohyun.blog.post.entity.Post;

import java.time.LocalDateTime;

public record PostResponse () {

    public record Register (
            String title,
            String content,
            String status,
            Boolean allowComment,
            LocalDateTime createdAt
    ) {
        public static Register from(String title, String content, String status, Boolean allowComment, LocalDateTime createdAt) {
            return new Register(title, content, status, allowComment, createdAt);
        }
    }

    public record GetPosts (
            String title,
            String nickname,
            LocalDateTime createdAt
    ) {
        public static GetPosts of(String title, String nickname, LocalDateTime createdAt) {
            return new GetPosts(title, nickname, createdAt);
        }
    }
}
