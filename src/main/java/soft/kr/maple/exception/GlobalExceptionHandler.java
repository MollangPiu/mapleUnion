package soft.kr.maple.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import soft.kr.maple.util.ResponseMessage;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseMessage> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        ResponseMessage responseMessage = new ResponseMessage();
        logger.error("HttpRequestMethodNotSupportedException", e);

        return new ResponseEntity<>(responseMessage, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        ResponseMessage responseMessage = new ResponseMessage();

        logger.error("handleIOException", e);

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}
