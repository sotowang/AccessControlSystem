package xjtu.soto.access.service;

import xjtu.soto.access.pojo.ThirdLocateEntity;

import java.util.List;

public interface ThirdLocateService {
    List<ThirdLocateEntity> findAll();

    List<ThirdLocateEntity> findByTop(Long topId);

    ThirdLocateEntity save(ThirdLocateEntity thirdLocateEntity);
}
