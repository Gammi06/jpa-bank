package shop.mtcoding.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import shop.mtcoding.bank.config.enums.UserEnum;
import shop.mtcoding.bank.handler.LoginHandler;

// SecurityFilterChain : 미리 만들어진 14개의 필터 < 네거티브 정책
@Configuration // 재등록
public class SecurityConfig {

    // tip : Configuration에서 생성자 주입을 Autowired 사용하기
    @Autowired
    private LoginHandler loginHandler;

    // 스프링 Security는 회원가입할때 해쉬를 사용하지 않으면 막힘
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 커스텀
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // iframe 거부
        http.headers().frameOptions().disable();
        http.csrf().disable(); // 포스트맨 사용하려고

        http.authorizeHttpRequests()
                .antMatchers("/api/transaction/**").authenticated() // 로그인
                .antMatchers("/api/user/**").authenticated() // 로그인
                .antMatchers("/api/account/**").authenticated() // 로그인
                .antMatchers("/api/admin/**").hasRole("ROLE_" + UserEnum.ADMIN) // 권한: Admin
                .anyRequest().permitAll()
                .and()

                .formLogin() // 디폴트: x-www-form-urlencoded (post)로 되어있음
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/api/login") // 로그인 링크
                .successHandler(loginHandler) // 로그인 성공시
                .failureHandler(loginHandler); // 로그인 실패시

        return http.build();
    }
}
