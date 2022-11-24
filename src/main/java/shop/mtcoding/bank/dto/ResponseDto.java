package shop.mtcoding.bank.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// http code = 200(delete, update, select), 201(insert) <성공, 나머지는 모두 실패
@RequiredArgsConstructor
@Getter
public class ResponseDto<T> {
    private final String msg;
    private final T data;
}

// 변경될 일이 없으면 final, @RequiredArgsConstructor
