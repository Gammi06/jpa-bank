package shop.mtcoding.bank.config.exception;

public class CustomApiException extends RuntimeException {

    private final int httpStatusCode;

    public CustomApiException(String msg, int httpStatusCode) {
        super(msg);
        this.httpStatusCode = httpStatusCode;
    }
}

// Runtime~로 못 잡으면 Stack~가 리턴됨(Spring이 리턴해줌)