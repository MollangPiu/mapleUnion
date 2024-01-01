package soft.kr.maple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soft.kr.maple.entity.Member;
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
    public void MemberJoinFindId(@RequestBody Member member) {
        System.out.println("확인");
        System.out.println(member.getId());
    }
    
    @GetMapping("/find")
    public void MemberFind() {
        System.out.println("member");
    }
    
    

}
