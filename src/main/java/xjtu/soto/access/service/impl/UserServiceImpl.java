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
    public Page<UserEntity> findAll() {
        return userRepository.findAll(new PageRequest(1, 20, new Sort(new Sort.Order(Sort.Direction.ASC, "name"))));
    }

    @Transactional
    @Override
    public UserEntity save(UserEntity user) {
        String cardId = user.getCardid();
        if (cardId == null) {
            log.error("要保存的cardId为空");
        }
        user.setCardid(cardId);
        return userRepository.save(user);
    }


}
