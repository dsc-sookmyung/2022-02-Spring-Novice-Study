package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Getter //이후 선언되는 모든 필드에 getter 자동 생성
@RequiredArgsConstructor //선언된 final 필드 한정 constructor 자동 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
