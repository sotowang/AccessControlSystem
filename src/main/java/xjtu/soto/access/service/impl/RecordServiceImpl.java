package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.RecordEntity;
import xjtu.soto.access.repository.RecordRepository;
import xjtu.soto.access.service.RecordService;

import java.util.Date;
import java.util.List;
@Service
@Slf4j
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;
    @Override
    @Transactional
    public RecordEntity add(RecordEntity record) {
        return recordRepository.save(record);
    }

    @Override
    @Transactional
    @Modifying
    public void delete(RecordEntity record) {
        recordRepository.delete(record);
    }

    @Override
    public List<RecordEntity> findByCardId(String cardId) {

        return  recordRepository.findByCardid(cardId);
    }

    @Override
    public List<RecordEntity> findByFId(Long fid) {
        return recordRepository.findByFid(fid);
    }

    @Override
    public List<RecordEntity> findByTime(Date time1, Date time2) {
        return recordRepository.findByTimeBetween(time1, time2);
    }

    @Override
    public List<RecordEntity> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public List<RecordEntity> findByNameLike(String name) {
        name = "%" + name + "%";
        List<RecordEntity> recordEntities = recordRepository.findByNameLike(name);
        return recordEntities;
    }


    @Override
    public List<RecordEntity> findByTypeAndRoleAndDepartmentAndFidAndLocateAndTimeBetween(Integer type, Long role, Long department, Long fid,Long locate, Date time1, Date time2) {
        return recordRepository.findByTypeAndRoleAndDepartmentAndFidAndLocateAndTimeBetween(type, role, department, fid, locate, time1, time2);
    }

    @Override
    public List<RecordEntity> findByTypeAndRoleAndDepartmentAndCardidAndFidAndLocateAndTimeBetween(Integer type, Long role, Long department, String cardid, Long fid,Long locate, Date time1, Date time2) {
        return recordRepository.findByTypeAndRoleAndDepartmentAndCardidAndFidAndLocateAndTimeBetween(type, role, department, cardid, fid, locate,time1, time2);
    }

}
