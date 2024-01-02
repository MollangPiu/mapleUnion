package soft.kr.maple.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soft.kr.maple.exception.TestException;
import soft.kr.maple.service.CharacterService;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CharacterService characterService;

    @GetMapping("/regist")
    public void CharacterInsert(@RequestParam(value="character_id") String character_id) throws TestException, Exception {

        logger.info("regist");

        characterService.insertCharcter(character_id);

    }
}
