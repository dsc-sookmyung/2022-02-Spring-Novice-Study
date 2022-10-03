package com.jojoldu.book.freelecspringboot2webservice.web;

import com.jojoldu.book.freelecspringboot2webservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json 반환
public class HelloController {

    @GetMapping("/hello") // Get요청 받는 API 생성
    public String hello() {
        return "hello"; //화면에 hello 표시
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        //사용자가 api로 넘긴 name, amount이름으로 넘긴 파라미터를 캐치함
        return new HelloResponseDto(name, amount); //객체에 넣고 생성해 return
    }
}
