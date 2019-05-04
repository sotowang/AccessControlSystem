package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xjtu.soto.access.pojo.PermissionEntity;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<PermissionEntity, Long> {
    PermissionEntity findById(Long id);
}
