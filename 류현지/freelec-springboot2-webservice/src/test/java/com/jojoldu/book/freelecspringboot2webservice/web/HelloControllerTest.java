package com.jojoldu.book.freelecspringboot2webservice.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)

public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; // 스프링 MVC 테스트 시작점 / Http method API 테스트

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) //"/hello" 주소로 HTTP GET 요청 (MockMvc method)
                .andExpect(status().isOk()) //HTTP Header의 Status 검증 (200 / 그 외)
                .andExpect(content().string(hello)); //응답 본문 내용 검증
                //체이닝--> 여러 검증 한번에 선언
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto") //"/hello/dto" 주소로 HTTP GET 요청 (MockMvc method)
                                .param("name", name) //요청 파라미터 - name와 비교
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())//HTTP Header의 Status 검증 (200 / 그 외)
                .andExpect(jsonPath("$.name", is(name)))//JSON 응답값 중 name 필드 검증
                .andExpect(jsonPath("$.amount", is(amount)));//JSON 응답값 중 amount 필드 검증

    }
}

