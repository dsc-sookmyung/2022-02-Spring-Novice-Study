package com.jojoldu.book.springboot.web.dto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

//선언된 모든 필드의 get 메소드를 생성해 준다.
@Getter
// 선언된 모든 final 필드가 포함된 생성자를 생성해 준다.
@RequiredArgsConstructor

public class HelloResponseDto {
    private final String name;
    private final int amount;
}