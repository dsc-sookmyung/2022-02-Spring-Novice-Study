package com.book.springboot.web;

import com.book.springboot.service.posts.PostsService;
import com.book.springboot.web.dto.PostsResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;


public class IndexController {

    private final PostsService postsService;

    public IndexController() {
        postsService = null;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}
