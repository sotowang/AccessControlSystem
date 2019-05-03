package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.FacilityEntity;

public interface FacilityRepository extends JpaRepository<FacilityEntity, Long> {
    FacilityEntity findByFid(Long id);
}
