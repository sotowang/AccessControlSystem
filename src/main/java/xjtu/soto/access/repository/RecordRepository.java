package xjtu.soto.access.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xjtu.soto.access.pojo.RecordEntity;

import java.util.Date;
import java.util.List;

public interface RecordRepository extends JpaRepository<RecordEntity,Long> {

    List<RecordEntity> findByRecordId(Long id);

    List<RecordEntity> findByCardid(String cardId);

    List<RecordEntity> findByFid(Long fid);

    List<RecordEntity> findByTimeBetween(Date time1, Date time2);

    //查找全部
    List<RecordEntity> findAll();

    /**
     * 按名字模糊查找
     */
    Page<RecordEntity> findByNameLike(String name, Pageable pageable);
}
