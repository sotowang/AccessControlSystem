package xjtu.soto.access.service;

import xjtu.soto.access.pojo.FacilityEntity;

import java.util.List;

public interface FacilityService {
    void deleteById(Long id);

    void save(FacilityEntity facilityEntity);

    List<FacilityEntity> findAll();

    FacilityEntity findById(Long id);

}
