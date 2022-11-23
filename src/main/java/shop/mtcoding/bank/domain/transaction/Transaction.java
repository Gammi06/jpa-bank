package shop.mtcoding.bank.domain.transaction;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.mtcoding.bank.domain.account.Account;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // hivernate만 new할 수 있도록
@Getter
@Table(name = "transaction") // 테이블명
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    private String username;

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)) // null 허용
    @ManyToOne(fetch = FetchType.LAZY)
    private Account withdrawAccount; // 출금 계좌

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @ManyToOne(fetch = FetchType.LAZY)
    private Account depositAccount; // 입금 계좌

    private Long account; // 금액

    // 거래 후 잔액
    private Long withdrawAccountBalance;
    private Long depositAccountBalance;
}

/*
 * <스키마 구조>
 * 이체이력을 남김
 * from to
 * 1. [어떤 계좌]가 [어떤 계좌]에 [얼마]를 [이체,입금,출금]을 했는지
 * 1111 / 2222 / 3,000 / 이체 (인증, 권한 필요)
 * null(atm) / 1111 / 4,000 / 입금 (인증, 권한 필요X)
 * 1111 / null / 2,000 / 출금 (인증, 권환 필요)
 */
