package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xjtu.soto.access.pojo.SecondLocateEntity;
import xjtu.soto.access.pojo.ThirdLocateEntity;

import java.util.List;

public interface ThirdLocateRepository extends JpaRepository<ThirdLocateEntity, Long> {

    List<ThirdLocateEntity> findByTop(Long topId);

    ThirdLocateEntity findById(Long id);


}
