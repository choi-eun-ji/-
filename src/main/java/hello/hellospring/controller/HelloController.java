package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("hello-mvc")
    // @RrequestParam("")이 get방식으로 주소창에 쿼리스트링 방식으로 넘겨주면 그 값이 name으로 들어가서 view단으로 넘겨주는 것이다.
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // html 태그 없이 단순 문자열만 출력
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체를 반환 => json 형태인 키 값으로 출력됨
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
