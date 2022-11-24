package shop.mtcoding.bank.temp.config.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import shop.mtcoding.bank.config.exception.CustomApiException;

public class CustomApiExceptionTest {

    @Test
    public void CustomApi_test() throws Exception {
        // given
        String msg = "해당 id가 없습니다";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        // when
        CustomApiException customApiException = new CustomApiException(msg, httpStatus);

        // then
        // assertThat(ex.httpStatusCode().value()).isEqualTo(400);
        // assertThat(ex.getMessage()).isEqualTo("해당 id가 없습니다");
    }
}
