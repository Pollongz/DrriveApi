package com.drrive.DrriveApi.controller;

import com.drrive.DrriveApi.entity.Post;
import com.drrive.DrriveApi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPost() {
        return postService.getPosts();
    }

    @GetMapping(path = "/{idPost}")
    public Post getOnePost(@PathVariable("idPost") Integer idPost) {
        return postService.getPostById(idPost);
    }

    @PostMapping
    public Post addNewPost(@RequestBody Post post) {
        return postService.addNewPost(post);
    }

    @PostMapping(path = "/{idPost}")
    public Post updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @DeleteMapping(path = "/{idPost}")
    public String deletePost(@PathVariable("idPost") Integer idPost) {
        return postService.deletePost(idPost);
    }
}
