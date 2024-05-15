package com.example.esun.service.impl;

import com.example.esun.dao.CommentDao;
import com.example.esun.dao.PostDao;
import com.example.esun.dao.UsersDao;
import com.example.esun.model.Comment;
import com.example.esun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private PostDao postDao;

    @Override
    public void addComment(Long userId, Long postId, String content) {

        Comment comment = new Comment();
        comment.setUser(usersDao.findByUserId(userId));
        comment.setPost(postDao.findByPostId(postId));
        comment.setContent(content);
        Date today = new Date();
        comment.setCreatedAt(today);
        commentDao.save(comment);
    }
}
