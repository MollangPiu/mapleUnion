package soft.kr.maple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soft.kr.maple.service.CharacterService;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/regist")
    public void CharacterInsert(@RequestParam(value="character_id") String character_id) {



    }
}
