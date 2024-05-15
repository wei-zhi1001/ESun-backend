package com.example.esun.dao;



import com.example.esun.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PostDao extends JpaRepository<Post, Long> {
    Post findByPostId(Long postId);
}
