package xjtu.soto.access.service;

import xjtu.soto.access.pojo.WhitelistEntity;

import java.util.List;

public interface WhiteListService {
    List<WhitelistEntity> findAll();


    WhitelistEntity findByID(Long id);

    WhitelistEntity save(WhitelistEntity whitelistEntity);

}
