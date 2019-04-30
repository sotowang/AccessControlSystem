package xjtu.soto.access.service;

import xjtu.soto.access.pojo.TopLocateEntity;

import java.util.List;

public interface TopLocateService {
    TopLocateEntity save(TopLocateEntity topLocateEntity);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    TopLocateEntity findById(Long id);


    void deleteById(Long id);

    List<TopLocateEntity> findAll();
}
