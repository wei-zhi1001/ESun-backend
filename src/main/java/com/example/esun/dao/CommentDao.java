package com.example.esun.dao;

import com.example.esun.model.Comment;
import com.example.esun.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Long> {
    List<Comment> findByPost(Post post);
}
