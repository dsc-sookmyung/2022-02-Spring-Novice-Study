package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import com.jojoldu.book.freelecspringboot2webservice.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/") //URL접속 시 기본페이지(/)에 index 템플릿 매핑
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        //findAllDesc()로 가져온 결과를 posts 객체로 -> index에 전달
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
