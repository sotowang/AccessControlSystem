package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xjtu.soto.access.pojo.SecondLocateEntity;

import java.util.List;

public interface SecondLocateRepository extends JpaRepository<SecondLocateEntity, Long> {

    List<SecondLocateEntity> findByTop(Long topId);
}
