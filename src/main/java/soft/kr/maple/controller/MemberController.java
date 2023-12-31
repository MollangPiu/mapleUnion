package soft.kr.maple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public void MemberJoinFindId(@RequestBody @RequestParam(value="id", required = false) String id) {
        System.out.println("확인");
        System.out.println(id);
    }
    
    @GetMapping("/find")
    public void MemberFind() {
        System.out.println("member");
    }
    
    

}
