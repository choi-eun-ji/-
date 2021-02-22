package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IAttribute;

@Controller
public class HelloController {

    // 스프링에서 get방식 전송과 같은 말 = @GetMapping
    @GetMapping("hello")
    public String hello(Model model){
       model.addAttribute("data","spring!!");

       // 컨트롤러에서 리턴 값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리한다.
       return "hello";  // templates 폴터 밑에 hello.html view단을 return 한다는 의미이다.
    }
}
