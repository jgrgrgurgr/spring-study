package hello.hello_spring.controller;

import org.springframework.ui.Model; //여기서 model은 view와 Controller 간의 데이터 전달을 돕는 객체 역할을 수행합니다.
import org.springframework.stereotype.Controller; //Controller는 화면(view)에서 요청한 주소를 받아들여 어디로 갈 지 분석하고 맞는 길(business logic)로 연결시켜주는 다리 역할을 수행합니다.
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //GetMapping은 요청주소와 실제주소를 Mapping 하도록(해당 값이 다른 값을 가르키도록)하는 어노테이션입니다.
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //addAttribute("String name","Object value")을 통해 value 객체가 name으로 추가되고, view에서 name으로 지정된 value를 사용하게 됩니다.
        return "hello";
    }
}
