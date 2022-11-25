package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class HelloResponseDtoTest {

    @Test //HelloResponseDto의 getter, constructor가 잘 생성되는지 확인 위해 annotation 추가
    public void 롬복_기능_테스트() {

        //(1)given
        String name = "test";
        int amount = 1000;

        //(2)when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //(3)then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);


    }
}
