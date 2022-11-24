package shop.mtcoding.bank.config.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shop.mtcoding.bank.config.exception.CustomApiException;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.domain.user.UserRepository;

@Service
public class LoginUserService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(getClass()); // 스닙팩 제작

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.debug("디버그 : loadUserByUsername 실행됨");

        // 디비에 유저네임이 있는지만 체크 (패스워드 체크는 얘가 알아서 해줌)
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new CustomApiException("username을 찾을 수 없습니다", HttpStatus.BAD_REQUEST));
        return new LoginUser(user);
    }
    // APIException 다 만든 후에 SecurityException 만들기!(중요)
}
