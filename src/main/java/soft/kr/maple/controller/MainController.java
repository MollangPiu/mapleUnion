package soft.kr.maple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainStart() {

        System.out.println("main");
        return "redirect:/login";
    }

    @GetMapping("/joinMove")
    public String joinPageMove() {
        return "/member/regist";
    }

    @GetMapping("/login")
    public String login() {

        System.out.println("login");
        return "login";
    }

}
