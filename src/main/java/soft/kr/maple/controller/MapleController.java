package soft.kr.maple.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MapleController {


    /*@PersistenceContext
    EntityManager entityManager;
*/
    @GetMapping("/test")
    public void test() {

    }

}
