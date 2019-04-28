package xjtu.soto.access.service;

import org.springframework.data.domain.Page;
import xjtu.soto.access.pojo.UserEntity;

import java.util.List;

public interface UserService {
    //根据cardId删除用户
    void deleteUserByCardid(String cardId);

    //根据cardId查找用户
    UserEntity findUserByCardid(String cardId);

    //根据名字查找用户
    List<UserEntity> findUserByName(String name);

    //查询所有用户
    List<UserEntity> findAll();


    //保存用户
    UserEntity save(UserEntity user);
}
