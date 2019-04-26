package xjtu.soto.access.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void deleteUserEntitiesByCardid() {
    }

    @Test
    public void findUserEntitiesByCardid() {
    }

    @Test
    public void findUserEntitiesByName() {
        userRepository.findByName("王松涛");
    }

    @Test
    public void findAll() {
        userRepository.findAll();
    }
}