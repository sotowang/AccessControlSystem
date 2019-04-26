package xjtu.soto.access.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepository1Test {

    @Autowired
    UserRepository1 userRepository1;
    @Test
    public void findByName() {
         userRepository1.findByName("sotowang");
    }

    @Test
    public void findByEmailAndName() {
    }
}