package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")   //  HTTP Method인 Get의 요청을 받을 수 있는 API 만들어 줌.
    public HelloResponseDto helloDto(@RequestParam("name") String name, // RequestParam : 외부에서 API로 넘긴 파라미터 가져오는 어노테이션
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
