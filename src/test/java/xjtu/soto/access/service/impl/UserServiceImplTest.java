package xjtu.soto.access.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xjtu.soto.access.pojo.UserEntity;
import xjtu.soto.access.repository.UserRepository;

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
        UserEntity userEntity = userService.findUserByCardid("3118311061");
        Assert.assertEquals(userEntity.getName(), "王松涛");
    }

    @Test
    public void findUserByName() {
        userService.findUserByName("sotowang");
    }

    @Test
    public void findAllUser() {
         userService.findAll();
    }


    @Test
    public void save() {
        UserEntity user = new UserEntity("3118311064", "test1", 1, "软件学院", "password");
        userService.save(user);
    }
    @Test
    public void delete() {
        userService.deleteUserByCardid("8888888");
    }

}