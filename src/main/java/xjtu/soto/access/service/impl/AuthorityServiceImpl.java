package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xjtu.soto.access.pojo.PermissionEntity;
import xjtu.soto.access.repository.AuthorityRepository;
import xjtu.soto.access.service.AuthorityService;

@Slf4j
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public PermissionEntity getAuthorityById(Long id) {
        return authorityRepository.findById(id);
    }

}
