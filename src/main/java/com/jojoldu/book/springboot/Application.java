package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//컴파일러에게 코드 작성 문법 에러를 체크하도록 정보를 제공
// 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 모두 자동으로 설정.
// 특히, @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에, 이 클래스는 항상 프로젝트 최상단에 있어야 함.
public class Application {
    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
    }
}
