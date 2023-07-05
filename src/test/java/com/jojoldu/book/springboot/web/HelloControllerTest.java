package com.jojoldu.book.springboot.web;

import org.apache.catalina.security.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
// 테스트를 진행할 때 Junit에 내장된 실행자 외에 다른 실행자를 실행시킨다. 왜.??
// 여기서는 SpringRunner라는 실행자를 사용
// 스프링 부트 테스트와 Junit 사이에 연결자 역할
@WebMvcTest
//여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션

public class HelloControllerTest {
    @Autowired  // 스프링이 관리하는 빈(Bean)을 주입 받는다.
    private MockMvc mvc;
    // 웹 API를 테스트할 때 사용된다. 스프링 MVC 테스트의 시작점.
    // 이 클래스를 통해 HTTP, GET, POST 등에 대한 API를 테스트 할 수 있다.
    //The Spring MVC Test framework, also known as MockMvc, provides support for testing Spring MVC applications.
    //개발한 웹 프로그램을 실제 서버에 배포하지 않고도 테스트를 위한 요청을 제공하는 수단
    // Unit Test와 TDD 사이의 테스트.

    @Test
    public void hello_method() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //mvc.perform의 결과 검증. HTTP Header의 Status 검증. 우리가 알고 있는 200, 404, 500 오류. isOk는 200인지 아닌지
                .andExpect(content().string(hello));    //mvc.perform의 결과 검증(andExpect의 기능). 응답 본문의 내용 검증. Controller에서 hello를 리턴하기 때문에, 이 값이 맞는지 검증.
                // 여기서 final String name과 final int amount를 초기화 하지 않았다는 에러가 뜬다면 gradle version을 down시켜줘야 함
                // https://github.com/jojoldu/freelec-springboot2-webservice/issues/2 참고
    }

    @Test
    public void helloDto_method() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
