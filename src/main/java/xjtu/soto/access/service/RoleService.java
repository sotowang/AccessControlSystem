package xjtu.soto.access.service;

import xjtu.soto.access.pojo.IdentityEntity;

import java.util.List;

public interface RoleService {

    List<IdentityEntity> findAll();

    void deleteById(Long id);
}
