package com.jojoldu.book.freelecspringboot2webservice.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    //스프링 시큐리티 요구사항 : 권한 코드 앞에 ROLE_이 있어야 함
    //따라서 코드 별 키값 지정해줌
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

}
