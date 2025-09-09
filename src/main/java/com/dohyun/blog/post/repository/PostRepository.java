package com.dohyun.blog.post.repository;

import com.dohyun.blog.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

}
