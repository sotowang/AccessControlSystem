package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.IdentityEntity;
import xjtu.soto.access.repository.RoleRepository;
import xjtu.soto.access.service.RoleService;

import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<IdentityEntity> findAll() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    @Modifying
    public void deleteById(Long id) {
        roleRepository.delete(id);
    }

    @Override
    @Transactional
    public IdentityEntity save(IdentityEntity role) {
        roleRepository.save(role);
        return null;
    }

}
