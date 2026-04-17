package com.example.spring_mvc_study1_mvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale, // 언어 정보(ko_KR)
                          // MultiValueMap 는 하나의 key에 여러 value를 받을 수 있음. 배열이 반환됨
                          @RequestHeader MultiValueMap<String, String> headerMap, // 헤더를 여러개 한번에 받음
                          @RequestHeader("host") String host, // 헤더 중에서 "host"를 받음
                          @CookieValue(value = "myCookie", required = false) String cookie) { // "myCookie"라는 value의 쿠키를 받음

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }

}
