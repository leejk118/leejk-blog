package com.leejk.blog.service;

import com.leejk.blog.domain.Comment;
import com.leejk.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

}
