package shop.mtcoding.bank.util;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.bank.dto.ResponseDto;

public class CustomRespUtil {

    private static final Logger log = LoggerFactory.getLogger(CustomRespUtil.class);

    public static void sucess(HttpServletResponse response, Object dto) {

        try {
            ObjectMapper om = new ObjectMapper();
            ResponseDto<?> responseDto = new ResponseDto<>("로그인 성공", dto);
            String responseBody = om.writeValueAsString(responseDto);
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(200);
            response.getWriter().println(responseBody);
        } catch (Exception e) {
            log.error("디버그 : 서버 파싱 에러");
        }

    }

    public static void fail(HttpServletResponse response, String msg) {

        try {
            ObjectMapper om = new ObjectMapper();
            ResponseDto<?> responseDto = new ResponseDto<>(msg, null);
            String responseBody = om.writeValueAsString(responseDto); // json변환
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(400);
            response.getWriter().println(responseBody);
        } catch (Exception e) {
            log.error("디버그 : 서버 파싱 에러");
        }
    }

}
