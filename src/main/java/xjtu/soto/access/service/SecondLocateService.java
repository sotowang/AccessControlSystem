package xjtu.soto.access.service;

import xjtu.soto.access.pojo.SecondLocateEntity;

import java.util.List;

public interface SecondLocateService {
    /**
     * 查找全部
     * @return
     */
    List<SecondLocateEntity> findAll();

    List<SecondLocateEntity> findByTop(Long topId);

    void deleteById(Long id);
}
