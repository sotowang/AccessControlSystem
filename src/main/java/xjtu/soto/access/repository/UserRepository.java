package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {


    //根据cardId删除用户
    @Modifying
    @Transactional
    void deleteByCardid(String cardId);

    //根据cardId查找用户
    UserEntity findByCardid(String cardId);

    //根据名字查找用户
    List<UserEntity> findByName(String name);


    //按名字模糊查找
    List<UserEntity> findByNameLike(String name);

}
