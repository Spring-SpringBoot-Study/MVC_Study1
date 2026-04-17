package com.example.spring_mvc_study1_mvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
// RestController는 return 결과를 ViewResolver를 거치지 않고, HttpMessageConverter가 동작해서 문자열 그대로를 response body에 전송함
public class MappingController {

    /**
     * 기본 요청
     * 둘다 허용 /hello-basic, /hello-basic/
     * HTTP 메서드 모두 허용 GET, HEAD, POST, PUT, PATCH, DELETE
     */
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("hello-basic");
        return "ok";
    }

    /**
     * method 특정 HTTP 메서드 요청만 허용
     * GET, HEAD, POST, PUT, PATCH, DELETE
     */
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션 (코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /**
     * PathVariable 사용 - Path Parameter 방식
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable String userId
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug") // && 조건으로 value와 params가 붙기 때문에 두 조건을 모두 만족해야 해당 함수가 호출됨
    // /mapping-param?mode=debug 와 같은 형식의 요청일 때 매핑
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    // /mapping-header" 와 같은 형식의 요청 + 요청 header에 (key, value) -> (mode, debug)가 있어야만 매핑
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    // /mapping-consume" 과 같은 형식의 요청 + 요청 header의 Content-Type이 "application/json"일 경우 매핑
    // Content-Type : 전송하는 body에 담긴 데이터의 형식이 어떤 형식인지
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    // /mapping-produce" 과 같은 형식의 요청 + 요청 header의 Accept가 "text/html"일 경우 매핑
    // Accept : 클라이언트가 서버에게 나는 이런 형식의 데이터를 이해할 수 있으니, 결과물을 어떤 형식으로 받을지
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
