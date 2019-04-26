package xjtu.soto.access.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xjtu.soto.access.pojo.UserEntity;
import xjtu.soto.access.repository.UserRepository;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void deleteUserByCardid() {

        userService.deleteUserByCardid("3118311061");
    }

    @Test
    public void findUserByCardid() {
        userRepository.findByCardid("3118311061");
    }

    @Test
    public void findUserByName() {
        userRepository.findByName("sotowang");
    }

    @Test
    public void findAllUser() {
         userService.findAll();
    }


    @Test
    public void save() {
        UserEntity user = new UserEntity("3118311063", "test1", 1, "软件学院", "password");

        userRepository.save(user);
    }

}