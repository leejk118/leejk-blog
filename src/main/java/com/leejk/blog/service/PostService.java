package com.leejk.blog.service;

import com.leejk.blog.domain.Post;
import com.leejk.blog.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Page<Post> findAllByOrderByCreatedDateDesc(Pageable pageable) {
        return postRepository.findAllByOrderByCreatedDateDesc(pageable);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post update(Integer postId, Post updatedPost) {
        Post findPost = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post Entity Not Found"));

        findPost.updatePost(updatedPost.getTitle(), updatedPost.getContents());
        return postRepository.save(findPost);
    }

    public Post findById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    public void delete(Integer postId) {
        postRepository.deleteById(postId);
    }

}
