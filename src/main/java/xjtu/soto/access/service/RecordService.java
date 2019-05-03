package xjtu.soto.access.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xjtu.soto.access.pojo.FacilityEntity;
import xjtu.soto.access.pojo.RecordEntity;

import java.util.Date;
import java.util.List;

public interface RecordService {
    RecordEntity add(RecordEntity record);


    void delete(RecordEntity record);


    List<RecordEntity> findByCardId(String cardId);

    List<RecordEntity> findByCardIdAndTimeBetween(String cardid, Date time1, Date time2);

    List<RecordEntity> findByFIdAndBetween(Long fid, Date time1, Date time2);


    List<RecordEntity> findByTime(Date time1, Date time2);


    List<RecordEntity> findAll();

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<RecordEntity> findByNameLike(String name);


    List<RecordEntity> findByTypeAndRoleAndDepartmentAndFidAndLocateAndTimeBetween(
            Integer type, Long role, Long department, Long fid,Long locate, Date time1, Date time2
    );

    List<RecordEntity> findByTypeAndRoleAndDepartmentAndCardidAndFidAndLocateAndTimeBetween(
            Integer type,Long role,Long department,String cardid,Long fid,Long locate,Date time1,Date time2);


}
