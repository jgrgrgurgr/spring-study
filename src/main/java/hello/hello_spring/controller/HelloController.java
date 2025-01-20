package hello.hello_spring.controller;

import org.springframework.ui.Model; //여기서 model은 view와 Controller 간의 데이터 전달을 돕는 객체 역할을 수행합니다.
import org.springframework.stereotype.Controller; //Controller는 화면(view)에서 요청한 주소를 받아들여 어디로 갈 지 분석하고 맞는 길(business logic)로 연결시켜주는 다리 역할을 수행합니다.
import org.springframework.web.bind.annotation.GetMapping; //GetMapping은 요청주소와 실제주소를 Mapping 하도록(해당 값이 다른 값을 가르키도록)하는 어노테이션입니다.
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //addAttribute("String name","Object value")을 통해 value 객체가 name으로 추가되고, view에서 name으로 지정된 value를 사용하게 됩니다.
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) { //RequestParam은 파라미터 이름으로 바운딩()되는 방법으로, 요청 파라미터를 매우 편리하게 사용할 수 있습니다.
        model.addAttribute("name", name);
        return "hello-template"; //템플릿 엔진 위에서 문자값이 출력됩니다.
    }

    @GetMapping("hello-string")
    @ResponseBody //ResponseBody 어노테이션으로 HTTP의 body부에 데이터를 직접 삽입할 수 있습니다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //작성한 문자값만이 그대로 출력됩니다.
    }

    //데이터 출력 방식의 경우, 다음과 같이 나타낼 수 있습니다.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name); //문자(StringConverter로 처리)가 아닌 객체(JsonConverter로 처리)를 집어넣습니다.
        return hello;
    }

    static class Hello { //static으로 선언하였으므로 외부 클래스를 사용할 수 있습니다.
        private String name;

        public String getName() { //값을 꺼내는 경우
            return name;
        }

        public void setName(String name) { //값을 집어넣는 경우
            this.name = name;
        }
    }
}
