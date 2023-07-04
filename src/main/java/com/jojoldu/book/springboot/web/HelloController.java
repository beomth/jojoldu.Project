package com.jojoldu.book.springboot.web;
//패키지 이름은 보통 웹 도메인 반대로 생성
// Controller는 View와 비즈니스 로직(Model) 사이의 다리를 잇는 역할. 행동에 대한 정의.
// Controller와 관련된 내용은 앞으로 모두 여기에 추가

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 준다.
// 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해줌.
public class HelloController {

    @GetMapping("/hello")
    // HTTP Method인 GET의 요청을 받을 수 있는 API를 만들어줌.
    //예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용되었다. 이제 이 프로젝트는 /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가지게 됨.
    public String hello(){
        return "hello";
    }

}
