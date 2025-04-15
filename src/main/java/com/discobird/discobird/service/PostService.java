package com.discobird.discobird.service;

import com.discobird.discobird.domain.Post;
import com.discobird.discobird.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    /**
     * Get all posts
     * @return a list of all posts
     */
    public List<Post> getAllPosts(){
        return repository.findAll();
    }

    /**
     * Get one post using id
     * @param id the ID of the post to retrieve
     * @return an Optional containing the post if found, or empty if not
     */
    public Optional<Post> getPostById(Long id){
        return repository.findById(id);
    }

    /**
     * Save the post
     * @param post the post to save
     * @return the saved post
     */
    public Post savePost(Post post){
        return repository.save(post);
    }

    /**
     * Delete the post
     * @param id the ID of the post to delete
     */
    public void deletePost(Long id){
        repository.deleteById(id);
    }

}
