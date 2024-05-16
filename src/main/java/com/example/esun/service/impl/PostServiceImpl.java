package com.example.esun.service.impl;

import com.example.esun.dao.CommentDao;
import com.example.esun.dao.PostDao;
import com.example.esun.model.Comment;
import com.example.esun.model.Post;
import com.example.esun.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private CommentDao commentDao;

    @Override
    public boolean addPost(Post post) {
        postDao.save(post);
        return true;
    }

    @Override
    public List<Post> getAllPosts() {
        return postDao.findAll();
    }

    @Override
    public boolean editPost(Long postId, String content, String image) {
        Optional<Post> dbPost = postDao.findById(postId);
        if (dbPost.isPresent())
        {
            if(!Objects.equals(dbPost.get().getContent(), content))
            {
                dbPost.get().setContent(content);
            }
            if(!Objects.equals(dbPost.get().getImage(), image))
            {
                dbPost.get().setImage(image);
            }
            postDao.save(dbPost.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePost(Long postId) {
        Optional<Post> optionalPost = postDao.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            // 刪除與帖子相關的評論
            List<Comment> comments = post.getComments();
            for (Comment comment : comments) {
                commentDao.delete(comment);
            }
            // 最後刪除帖子本身
            postDao.delete(post);
            return true;
        } else {
            return false; // 如果帖子不存在，返回false
        }
    }
}
