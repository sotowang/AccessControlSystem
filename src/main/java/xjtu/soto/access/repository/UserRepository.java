package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xjtu.soto.access.pojo.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //根据cardId删除用户
    void deleteUserEntitiesByCardid(String cardId);

    //根据cardId查找用户
    UserEntity findUserEntitiesByCardid(String cardId);

    //根据名字查找用户
    List<UserEntity> findUserEntitiesByName(String name);



}
