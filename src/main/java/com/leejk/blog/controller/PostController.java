package com.leejk.blog.controller;

import com.leejk.blog.domain.Post;
import com.leejk.blog.dto.post.PostAddForm;
import com.leejk.blog.dto.post.PostEditForm;
import com.leejk.blog.mapper.PostAddMapper;
import com.leejk.blog.mapper.PostEditMapper;
import com.leejk.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/list")
    public String posts(Model model, Pageable pageable) {
        Page<Post> page = postService.findAllByOrderByCreatedDateDesc(pageable);
        model.addAttribute("posts", page.getContent());
        model.addAttribute("page", page);
        return "post/list";
    }

    /**
     * 포스트 내용 조회
     *
     * @param postId
     * @param model
     * @return
     */
    @GetMapping("/post/{postId}")
    public String post(
            @PathVariable Integer postId,
            Model model) {
        model.addAttribute("post", postService.findById(postId));
        return "post/index";
    }

    /**
     * 포스트 추가 입력 폼
     *
     * @return
     */
    @GetMapping("/post/add")
    public String addPostForm(@ModelAttribute("post") PostAddForm postAddForm) {
        return "post/form/addForm";
    }

    /**
     * 포스트 추가 로직
     *
     */
    @PostMapping("/post/add")
    public String addPost(
            @ModelAttribute("post") PostAddForm postAddForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("Post Add Error => {}", bindingResult);
            return "redirect:/post/add";
        }

        Post savedPost = postService.save(PostAddMapper.MAPPER.toEntity(postAddForm));
        redirectAttributes.addAttribute("postId", savedPost.getId());
        return "redirect:/post/{postId}";
    }

    /**
     * 포스트 수정 입력 폼
     *
     * @param postId
     * @return
     */
    @GetMapping("/post/{postId}/edit")
    public String editPostForm(
            @PathVariable Integer postId,
            Model model) {
        model.addAttribute("post", postService.findById(postId));
        return "post/form/editForm";
    }

    /**
     * 포스트 수정 로직
     * 
     * @param postId
     * @param postEditForm
     * @param bindingResult
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/post/{postId}/edit")
    public String editPost(
            @PathVariable Integer postId,
            @ModelAttribute("post") PostEditForm postEditForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("Post Edit Error => {}", bindingResult);
            return "redirect:/post/list";
        }

        Post updatedPost = postService.update(postId, PostEditMapper.MAPPER.toEntity(postEditForm));
        redirectAttributes.addAttribute("postId", updatedPost.getId());
        return "redirect:/post/{postId}";
    }

    @DeleteMapping("/post/{postId}")
    public String deletePost(@PathVariable Integer postId) {
        postService.delete(postId);
        return "redirect:/post/list";
    }

}
