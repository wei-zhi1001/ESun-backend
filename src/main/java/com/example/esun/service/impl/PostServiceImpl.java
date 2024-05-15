package com.example.esun.service.impl;

import com.example.esun.dao.PostDao;
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
    public void deletePost(Long postId) {
        postDao.deleteById(postId);
    }
}
