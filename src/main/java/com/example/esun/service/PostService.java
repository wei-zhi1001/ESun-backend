package com.example.esun.service;

import com.example.esun.model.Post;

import java.util.List;

public interface PostService {
    boolean addPost(Post post);
    List<Post> getAllPosts();
    boolean editPost(Long postId,String content,String image);
    void deletePost(Long postId);
}
