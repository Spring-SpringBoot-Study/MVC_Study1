package com.example.spring_mvc_study1_mvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");

        return "response/hello";
    }

    // 불명확해서 권장하지 않음, v2를 가장 일반적으로 사용
    @RequestMapping("/response/hello") // 컨트롤러의 경로 이름과 뷰의 논리적 이름이 같으면, 자동으로 return "response/hello" 가 있는 것처럼 동작
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }

    // 타임리프는 ThymeleafViewResolver에서 논리 주소를 물리 주소로 바꿈
    // 아래 2개가 default 값으로 application.properties 에 들어 있는 것임(바꾸고 싶으면, application.properties에서 변경 가능)
    // spring.thymeleaf.prefix=classpath:/templates/
    // spring.thymeleaf.suffix=.html
}
