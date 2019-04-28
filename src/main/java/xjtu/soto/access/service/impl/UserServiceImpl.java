package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.UserEntity;
import xjtu.soto.access.repository.UserRepository;
import xjtu.soto.access.service.UserService;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteUserByCardid(String cardId) {
        userRepository.deleteByCardid(cardId);
    }

    @Override
    public UserEntity findUserByCardid(String cardId) {
        return userRepository.findByCardid(cardId);
    }


    @Override
    public List<UserEntity> findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public UserEntity save(UserEntity user) {
        String cardId = user.getCardid();
        String name = user.getName();
        String password = user.getPassword();
        String department = user.getDepartment();
        int sex = user.getSex();
        if (cardId == null) {
            log.error("要保存的cardId为空");
        }
        UserEntity saveUser = new UserEntity(cardId, name, sex, department, password);
        return userRepository.save(saveUser);
    }


}
