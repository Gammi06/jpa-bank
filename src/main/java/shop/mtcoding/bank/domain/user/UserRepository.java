package shop.mtcoding.bank.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    // 네임드쿼리: findBy(피드명)을 사용하면 피드명으로 where을 검
    // (하지만 일관성을 위해서 쿼리를 작성하는것이 좋음)

    @Query("select u from User u where username = :username")
    Optional<User> findByUsername(@Param("username") String username);

}

// JPA에서 이미 만들어진 쿼리들은 테스트할 필요 없음