package soft.kr.maple.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TestException extends RuntimeException {

    public TestException() {
        super();
    }

    public TestException(String message, Throwable cause) {
        super(message, cause);
    }
}
