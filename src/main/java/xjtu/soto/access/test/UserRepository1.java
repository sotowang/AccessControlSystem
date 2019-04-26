package xjtu.soto.access.test;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository1 extends CrudRepository<User, Long> {

    List<User> findByName(String name);


    List<User> findByEmailAndName(String email, String name);
}