package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.SecondLocateEntity;
import xjtu.soto.access.repository.SecondLocateRepository;
import xjtu.soto.access.service.SecondLocateService;

import java.util.List;

@Service
@Slf4j
public class SecondLocateServiceImpl implements SecondLocateService {
    @Autowired
    private SecondLocateRepository secondLocateRepository;
    @Override
    public List<SecondLocateEntity> findAll() {
        return secondLocateRepository.findAll();
    }

    @Override
    public List<SecondLocateEntity> findByTop(Long topId) {
        return secondLocateRepository.findByTop(topId);
    }

    @Override
    @Transactional
    @Modifying
    public void deleteById(Long id) {
        secondLocateRepository.delete(id);
    }

    @Override
    @Transactional
    public void save(SecondLocateEntity secondLocateEntity) {
        secondLocateRepository.save(secondLocateEntity);
    }
}
