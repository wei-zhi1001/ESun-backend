package com.example.esun.controller;

import com.example.esun.model.Comment;
import com.example.esun.model.Post;
import com.example.esun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(allowCredentials = "true", origins = { "http://localhost:5173" })
public class CommentController
{
    @Autowired
    CommentService commentService;

    @PostMapping("comment/newComment")
    public String newComment(
            @RequestParam("userId") Long userId,
            @RequestParam("postId") Long postId,
            @RequestParam("content") String content) {

        commentService.addComment(userId,postId,content);
        return content;
    }
    @GetMapping("comment/listAll")
    public List<Comment> getAllComment() {
        return commentService.getAllComment();
    }
}
