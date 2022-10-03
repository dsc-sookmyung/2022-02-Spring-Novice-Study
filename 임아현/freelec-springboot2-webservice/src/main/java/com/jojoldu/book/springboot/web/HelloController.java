package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어준다.
@RestController
public class HelloController {

    //HTTP Method인 Get 요청을 받을 수 있는 API를 만들어준다.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    //RequestParam은 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션이다.
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }


}