package soft.kr.maple.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.kr.maple.entity.Member;

@RestController
@RequiredArgsConstructor
public class MapleController {


    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("/test")
    @Transactional
    public void test() {
        System.out.println("start");
        Member member = new Member();
        member.setId(1L);
        member.setName("Test");

        entityManager.persist(member);

        System.out.println( "Hello World!" );
    }

}