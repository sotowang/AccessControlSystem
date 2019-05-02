package xjtu.soto.access.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xjtu.soto.access.pojo.DepartmentEntity;
import xjtu.soto.access.repository.DepartmentRepository;
import xjtu.soto.access.service.DepartmentService;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    @Modifying
    public void deleteById(Long id) {
        departmentRepository.delete(id);
    }

    @Override
    @Transactional
    public void save(DepartmentEntity departmentEntity) {
        departmentRepository.save(departmentEntity);
    }

    @Override
    public List<DepartmentEntity> findAll() {
        return departmentRepository.findAll();
    }

}
