package com.discobird.discobird.repository;

import com.discobird.discobird.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Post> findAll();
//    Optional<Post> findById(Long id);
//    Post save(Post post);
//    Post update(Post post);
//    void deleteById(Long id);
}
