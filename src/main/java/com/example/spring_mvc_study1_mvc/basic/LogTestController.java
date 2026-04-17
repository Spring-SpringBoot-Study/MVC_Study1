package com.example.spring_mvc_study1_mvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
// @Controller + @ResponseBody 임
// 메서드가 반환하는 객체(객체, 리스트, 문자열 등)를 자동으로 JSON 형식으로 변환하여 HTTP 응답 본문(Response Body)에 담아 보냅
public class LogTestController {

    // org.slf4j.Logger, org.slf4j.LoggerFactory 사용 -> @Slf4j 어노태이션과 같은 기능
    // private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // {} 안에 name이 치환되는 것
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);

        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        // 해당 단계의 로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행 및 계산되어 메모리에 가지고 있음
        // 로그 단계가 debuf로 설정되어 있어서, trace 로그는 계산할 필요가 없는데, JAVA 언어에서 "+" 연산의 경우, 먼저 계산해서 메모리에 가지고 있음
        // 쓰지도 않는데, 계산해서 메모리에 공간을 자치하기 때문에, 메모리 낭비
        // 이런 방식으로 사용하면 X
        // log.trace("String concat log=" + name);
        return "ok";

    }
}
