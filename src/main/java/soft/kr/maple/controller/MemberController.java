package soft.kr.maple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.kr.maple.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;


    /**
     * 회원가입, 아이디 중복 체크
     */
    @PostMapping("/join/findId")
    public void MemberJoinFindId() {
        System.out.println("확인");
    }
    
    @GetMapping("/find")
    public void MemberFind() {
        System.out.println("member");
    }
    
    

}
