package xjtu.soto.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.WhitelistEntity;

import java.util.List;

public interface WhiteListRepository extends JpaRepository<WhitelistEntity,Long> {

    /**
     * 根据id进行查找
     * @return
     */
    WhitelistEntity findByWid(Long wid);

    /**
     * 根据cardId进行查找
     * @param cardId
     * @return
     */
    List<WhitelistEntity> findByCardid(String cardId);

    @Transactional
    @Modifying
    void deleteByWid(Long id);

}
