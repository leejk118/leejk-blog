package com.leejk.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {

    @GetMapping("/")
    public String index() {
        return "redirect:/post/list";
    }

}
