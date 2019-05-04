package xjtu.soto.access.service;

import xjtu.soto.access.pojo.PermissionEntity;

public interface AuthorityService {
    PermissionEntity getAuthorityById(Long id);
}
