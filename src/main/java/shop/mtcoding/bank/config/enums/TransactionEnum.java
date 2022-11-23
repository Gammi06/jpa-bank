package shop.mtcoding.bank.config.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransactionEnum {
    WITHDRAW("출금"), DEPOSIT("입금"), TRANSFER("이체");

    private String value;
}

// 이름이 딱히 각이 안서면 value라고 해주면 편하다
