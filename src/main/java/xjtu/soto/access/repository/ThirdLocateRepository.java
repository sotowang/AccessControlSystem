package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xjtu.soto.access.pojo.SecondLocateEntity;
import xjtu.soto.access.pojo.ThirdLocateEntity;

public interface ThirdLocateRepository extends JpaRepository<ThirdLocateEntity, Long> {

}
