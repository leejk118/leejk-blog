package com.leejk.blog.service;

import com.leejk.blog.domain.Post;
import com.leejk.blog.dto.post.PostEditForm;
import com.leejk.blog.mapper.PostEditMapper;
import com.leejk.blog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @Test
    public void 게시글_등록_테스트() {
        Post post = new Post("제목 1", "게시글 컨텐츠 111");

        Post savedPost = postService.save(post);
        Post findPost = postService.findById(savedPost.getId());

        assertThat(savedPost.getId()).isEqualTo(findPost.getId());
        assertThat(savedPost.getTitle()).isEqualTo(findPost.getTitle());
    }

    @Test
    void 게시글_수정_테스트() {
        Post post = new Post("제목 1", "게시글 컨텐츠 11");

        // post 저장
        Post savedPost = postService.save(post);

        // post 수정
        String editTitle = "제목 2";
        String editContents = "게시글 컨텐츠 22";
        PostEditForm postEditForm = new PostEditForm(savedPost.getId(), editTitle, editContents);

        Post mappedPost = PostEditMapper.MAPPER.toEntity(postEditForm);
        postService.update(savedPost.getId(), mappedPost);

        Post findPost = postService.findById(savedPost.getId());

        assertThat(findPost.getTitle()).isEqualTo(editTitle);
        assertThat(findPost.getContents()).isEqualTo(editContents);
    }

}