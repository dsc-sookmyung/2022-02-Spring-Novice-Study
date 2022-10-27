package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/") //URL접속 시 기본페이지(/)에 index 템플릿 매핑
    public String index(){
        return "index"; //머스테치 플러그인 -> 앞 경로 + 뒤 파일 확장자 명 자동 생략 가능
    }
    @GetMapping("/posts/save")//앞 슬래쉬 까먹지 말기
    public String postSave(){
        return "post-save"; //마찬가지로 URL (/posts/save) - 머스태치 파일 매핑
    }
}
