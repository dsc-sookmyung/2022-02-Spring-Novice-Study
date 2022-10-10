package com.jojoIdu.book.springboot.web;

import com.jojoIdu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON을 반환하는 컨트롤러를 만든다.
public class HelloController {

    @GetMapping("/hello/dto") //HTTP Method인 GET의 요청을 받을 수 있는 API를 만든다.
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
