package com.hcy.book.springboot.web;

import com.hcy.book.springboot.config.auth.LoginUser;
import com.hcy.book.springboot.config.auth.dto.SessionUser;
import com.hcy.book.springboot.service.posts.PostsService;
import com.hcy.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

//    @GetMapping("/")
//    public String index(){
//        return "index";  // src/main/resources/templates/index.mustache
//    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc()); // 메서드 결과로 가져온 posts를 index.mustache에 전달한다
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");  // 로그인 성공시 값을 가져온다

        if (user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
