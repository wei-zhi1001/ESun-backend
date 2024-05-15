package com.example.esun.controller;


import com.example.esun.model.Post;
import com.example.esun.service.PostService;
import com.example.esun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@CrossOrigin(allowCredentials = "true", origins = { "http://localhost:5173" })
public class PostController
{

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @PostMapping("post/newPost")
    public boolean newPost(
            @RequestParam("userId") Long userId,
            @RequestParam("content") String content,
            @RequestParam("image") String image
    ) {
        Post post = new Post();
        post.setUser(userService.getUserById(userId));
        post.setContent(content);
        post.setImage(image);

        Date today = new Date();
        post.setCreatedAt(today);

        return postService.addPost(post);
    }

    @GetMapping("post/listAll")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PutMapping("post/editPost")
    public boolean editPost(
            @RequestParam("postId") Long postId,
            @RequestParam("content") String content,
            @RequestParam("image") String image){

        return postService.editPost(postId,content,image);
    }

    @DeleteMapping("post/deletePost")
    public void deletePost(@RequestParam("postId") Long postId){
        postService.deletePost(postId);
    }
}
