package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.TopLocateEntity;
import xjtu.soto.access.repository.TopLocateRepository;
import xjtu.soto.access.service.TopLocateService;

import java.util.List;

@Slf4j
@Service
public class TopLocateServiceImpl implements TopLocateService {
    @Autowired
    private TopLocateRepository topLocateRepository;

    @Override
    @Transactional
    public TopLocateEntity save(TopLocateEntity topLocateEntity) {
        return topLocateRepository.save(topLocateEntity);
    }

    @Override
    public TopLocateEntity findById(Long id) {
        return topLocateRepository.findById(id);
    }

    @Override
    @Modifying
    @Transactional
    public void deleteById(Long id) {
        topLocateRepository.delete(id);
    }

    @Override
    public List<TopLocateEntity> findAll() {
        return topLocateRepository.findAll();
    }

}
