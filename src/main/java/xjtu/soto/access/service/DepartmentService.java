package xjtu.soto.access.service;

import xjtu.soto.access.pojo.DepartmentEntity;

import java.util.List;

public interface DepartmentService {

    void deleteById(Long id);

    void save(DepartmentEntity departmentEntity);

    List<DepartmentEntity> findAll();
}
