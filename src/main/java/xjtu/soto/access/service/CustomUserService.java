package xjtu.soto.access.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import xjtu.soto.access.pojo.UserEntity;
import xjtu.soto.access.repository.UserRepository;

public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByCardid(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户ID不存在");
        }

        System.out.println("s:" + s);
        System.out.println("cardId:" + user.getCardid() + ";password: " + user.getPassword());
        return user;
    }
}
