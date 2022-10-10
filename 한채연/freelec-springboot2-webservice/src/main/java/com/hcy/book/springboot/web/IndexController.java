package com.hcy.book.springboot.web;

import com.hcy.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc()); // 메서드 결과로 가져온 posts를 index.mustache에 전달한다
        return "index";
    }

}
