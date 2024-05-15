package com.example.esun.dao;

import com.example.esun.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Long> {
}
