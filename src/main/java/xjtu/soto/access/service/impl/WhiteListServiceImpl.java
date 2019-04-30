package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.WhitelistEntity;
import xjtu.soto.access.repository.WhiteListRepository;
import xjtu.soto.access.service.WhiteListService;

import java.util.List;

@Service
@Slf4j
public class WhiteListServiceImpl implements WhiteListService {
    @Autowired
    private WhiteListRepository whiteListRepository;
    @Override
    public List<WhitelistEntity> findAll() {
        return whiteListRepository.findAll();
    }

    @Override
    public WhitelistEntity findByID(Long id) {
        return whiteListRepository.findByWid(id);
    }

    @Override
    @Transactional
    public WhitelistEntity save(WhitelistEntity whitelistEntity) {
        return whiteListRepository.save(whitelistEntity);
    }

}
