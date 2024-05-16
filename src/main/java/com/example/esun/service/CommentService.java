package com.example.esun.service;

import com.example.esun.model.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Long userId,Long postId,String content);
    List<Comment> getAllComment();
}
