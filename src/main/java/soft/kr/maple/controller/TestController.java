package soft.kr.maple.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soft.kr.maple.util.ResponseMessage;
import soft.kr.maple.util.StatusEnum;

import java.nio.charset.Charset;


@RestController
@RequestMapping("/api/test")
public class TestController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/status/ok")
    public ResponseEntity testStatusOk() {


        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/status/badRequest")
    public ResponseEntity testStatus() {

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/status/entity")
    public ResponseEntity<ResponseMessage> status() {
        ResponseMessage responseMessage = new ResponseMessage();

        responseMessage.setStatus(StatusEnum.OK);
        responseMessage.setMessage("성공2");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/status/entityTwo")
    public ResponseEntity<ResponseMessage> statusTwo() {
        ResponseMessage responseMessage = new ResponseMessage();

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        responseMessage.setStatus(StatusEnum.OK);
        responseMessage.setMessage("성공2");
        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }
}
