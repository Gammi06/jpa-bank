package shop.mtcoding.bank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.domain.user.UserRepository;
import shop.mtcoding.bank.dto.UserReqDto.JoinReqDto;
import shop.mtcoding.bank.dto.UserRespDto.JoinRespDto;

@Transactional(readOnly = true) // Lazy
@RequiredArgsConstructor
@Service
public class UserService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public JoinRespDto join(JoinReqDto joinReqDto) {

        log.debug("디버그 : 회원가입 실행됨, 비밀번호 암호화");
        // 해시될때 비밀번호가 60자리가 됨

        // 1. 비밀번호 암호화
        // String rawPassword = joinReqDto.getPassword();
        // String encPassword = passwordEncoder.encode(rawPassword);
        joinReqDto.setPassword(passwordEncoder.encode(joinReqDto.getPassword()));

        log.debug("디버그 : 회원가입 save 완료");
        // 2. 회원가입
        User userPS = userRepository.save(joinReqDto.toEntity());

        log.debug("디버그 : DTO 응답");
        // 3. DTO 응답
        return new JoinRespDto(userPS);
    }
}
