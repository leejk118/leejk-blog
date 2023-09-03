package com.leejk.blog.repository;

import com.leejk.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.comments.CommentType;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
