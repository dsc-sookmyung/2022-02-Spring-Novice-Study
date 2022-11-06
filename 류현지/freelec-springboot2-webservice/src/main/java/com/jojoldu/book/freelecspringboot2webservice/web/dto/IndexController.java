package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import com.jojoldu.book.freelecspringboot2webservice.config.auth.LoginUser;
import com.jojoldu.book.freelecspringboot2webservice.config.auth.dto.SessionUser;
import com.jojoldu.book.freelecspringboot2webservice.domain.user.User;
import com.jojoldu.book.freelecspringboot2webservice.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/") //URL접속 시 기본페이지(/)에 index 템플릿 매핑
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        //findAllDesc()로 가져온 결과를 posts 객체로 -> index에 전달
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");
        //로그인 성공했다면 httpSession에 SessionUser 객체 저장돼 있을 것

        //user자체가 이미 SessionUser로 받아와서 바로 체크 가능
        if (user != null) { //세션에 저장된 값이 있을 경우에만 model에 userName 등록
            model.addAttribute("userName", user.getName());
        }

        return "index"; //머스테치 플러그인 -> 앞 경로 + 뒤 파일 확장자 명 자동 생략 가능
    }
    @GetMapping("/posts/save")//앞 슬래쉬 까먹지 말기
    public String postSave(){
        return "post-save"; //마찬가지로 URL (/posts/save) - 머스태치 파일 매핑
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
