package shop.mtcoding.bank.config.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomApiException extends RuntimeException {

    private final HttpStatus httpStatus;

    public CustomApiException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}

// Runtime~로 못 잡으면 Stack~가 리턴됨(Spring이 리턴해줌)