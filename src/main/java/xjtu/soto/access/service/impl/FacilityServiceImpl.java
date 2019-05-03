package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.FacilityEntity;
import xjtu.soto.access.repository.FacilityRepository;
import xjtu.soto.access.service.FacilityService;

import java.util.List;

@Slf4j
@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    @Transactional
    @Modifying
    public void deleteById(Long id) {
        facilityRepository.delete(id);
    }

    @Override
    @Transactional
    public void save(FacilityEntity facilityEntity) {
        facilityRepository.save(facilityEntity);
    }

    @Override
    public List<FacilityEntity> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public FacilityEntity findById(Long id) {
        return facilityRepository.findByFid(id);
    }


}
