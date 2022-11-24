package shop.mtcoding.bank.temp.util;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import shop.mtcoding.bank.util.CustomDateUtil;

public class CustomDateUtilTest {

    @Test
    public void toStringFormat_test() throws Exception {
        // given
        LocalDateTime localDateTime = LocalDateTime.now();

        // when
        String result = CustomDateUtil.toStringFormat(localDateTime);
        System.out.println("디버그 : " + result);

        // then

    }

}
