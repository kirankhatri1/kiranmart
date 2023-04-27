package com.kiranmart.kiranmart.department;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long>, DepartmentRepositoryCustom {

}
