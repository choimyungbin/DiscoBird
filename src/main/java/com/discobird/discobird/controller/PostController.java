package com.discobird.discobird.controller;

import com.discobird.discobird.domain.Post;
import com.discobird.discobird.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Get all posts
     */
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    /**
     * Get one post using id
     */
    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable("id") Long id){
        return postService.getPostById(id);
    }

    /**
     * Save the post
     */
    @PostMapping
    public Post savePost(@RequestBody Post post){
        return postService.savePost(post);
    }

    /**
     * Delete the post
     */
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }

}
