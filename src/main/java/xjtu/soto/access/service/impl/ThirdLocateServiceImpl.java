package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xjtu.soto.access.pojo.ThirdLocateEntity;
import xjtu.soto.access.repository.ThirdLocateRepository;
import xjtu.soto.access.service.ThirdLocateService;

import java.util.List;

@Slf4j
@Service
public class ThirdLocateServiceImpl implements ThirdLocateService {
    @Autowired
    private ThirdLocateRepository thirdLocateRepository;
    @Override
    public List<ThirdLocateEntity> findAll() {
        return thirdLocateRepository.findAll();
    }

    @Override
    public List<ThirdLocateEntity> findByTop(Long topId) {
        return thirdLocateRepository.findByTop(topId);
    }

    @Override
    public ThirdLocateEntity save(ThirdLocateEntity thirdLocateEntity) {
        return thirdLocateRepository.save(thirdLocateEntity);
    }

}
