package com.example.springProject1.dto;

import com.example.springProject1.web.HelloController;
import com.example.springProject1.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
