package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xjtu.soto.access.pojo.TopLocateEntity;

public interface TopLocateRepository extends JpaRepository<TopLocateEntity, Long> {

    TopLocateEntity findById(Long id);

}
