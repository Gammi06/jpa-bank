package shop.mtcoding.bank.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass // 자식이 이 어노테이션를 상속함 (= 자식이 테이블의 컬럼으로 만듬)
@EntityListeners(AuditingEntityListener.class) // insert나 update때마다 지켜봄
public abstract class AudingTime { // new할수 없도록 추상화

    @LastModifiedDate // insert, update시에 현재시간 들어감
    @Column(nullable = false)
    protected LocalDateTime updatedAt;

    @CreatedDate // insert시에 현재시간 들어감
    @Column(nullable = false)
    protected LocalDateTime createdAt;
}
