package soft.kr.maple.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MapleController {


    /*@PersistenceContext
    EntityManager entityManager;
*/
    @GetMapping("/test")
    @Transactional
    public void test() {
    }

}
