package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

        //assertj라는 테스트 검증 라이브러리의 검증 메소드. 검증하고 싶은 대상을 메소드 인자로 받는다.
        //Junit의 기본 assertThat이 아니다. Junit의 assertThat을 쓰면 is()와 같이 CireMatchers라이브러리가 필요.
        //IDE에서는 CoreMatchers같은 Matcher 라이브러리의 자동완성 지원이 약함.
    }
}
