package shop.mtcoding.bank.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shop.mtcoding.bank.domain.user.User;
import shop.mtcoding.bank.domain.user.UserRepository;

@Service
public class LoginUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // LoginUser loginUser = (LoginUser)
        // SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // 디비에 유저네임이 있는지만 체크 (패스워드 체크는 얘가 알아서 해줌)
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new RuntimeException("username을 찾을 수 없습니다"));
        return new LoginUser(user);
    }

}
