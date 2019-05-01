package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xjtu.soto.access.pojo.IdentityEntity;

public interface RoleRepository extends JpaRepository<IdentityEntity, Long> {

}
