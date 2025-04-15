package com.discobird.discobird.service;

import com.discobird.discobird.domain.Post;
import com.discobird.discobird.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostServiceTest {

    private PostRepository postRepository;
    private PostService postService;

    @BeforeEach
    void setUp() {
        postRepository = mock(PostRepository.class);
        postService = new PostService(postRepository);
    }

    @Test
    void testGetAllPosts() {
        Post post1 = new Post();
        Post post2 = new Post();
        postService.savePost(post1);
        postService.savePost(post2);
        when(postRepository.findAll()).thenReturn(Arrays.asList(post1, post2));

        List<Post> posts = postService.getAllPosts();

        assertEquals(2, posts.size());
        verify(postRepository, times(1)).findAll();
    }

    @Test
    void testGetPostById_Found() {
        Post post = new Post();
        post.setTitle("Test Title");
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        Optional<Post> result = postService.getPostById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test Title", result.get().getTitle());
        verify(postRepository).findById(1L);
    }

    @Test
    void testGetPostById_NotFound() {
        when(postRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Post> result = postService.getPostById(99L);

        assertFalse(result.isPresent());
        verify(postRepository).findById(99L);
    }

    @Test
    void testSavePost() {
        Post post = new Post();
        post.setTitle("New Post");

        when(postRepository.save(post)).thenReturn(post);

        Post saved = postService.savePost(post);

        assertEquals("New Post", saved.getTitle());
        verify(postRepository).save(post);
    }

    @Test
    void testDeletePost() {
        Long id = 1L;

        postService.deletePost(id);

        verify(postRepository, times(1)).deleteById(id);
    }
}
