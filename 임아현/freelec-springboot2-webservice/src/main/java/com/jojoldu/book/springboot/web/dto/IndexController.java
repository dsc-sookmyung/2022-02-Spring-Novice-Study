package com.jojoldu.book.springboot.web.dto;


import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        public String index (Model model, @LoginUser SessionUser user) {
            model.addAttribute("posts", postsService.findAllDesc());
            SessionUser user = (SessionUser) httpSession.getAttribute("user");
            if(user != null) {
                model.addAttribute("userName", user.getName());
            }
            return "index";
        }
    }


    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}