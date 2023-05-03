package com.kiranmart.kiranmart.employee;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>, EmployeeRepositoryCustom {

    @Query(value = "select * from tbl_employee where id =?1", nativeQuery = true)
    Employee findEmployeeById(Long id);


    @Query(value = "select * from tbl_employee where status = 1 and deleted = 0", nativeQuery = true)
    List<Employee> findAllByStatus();

    @Modifying
    @Transactional
    @Query(value = "delete from tbl_employee where id = :id", nativeQuery = true)
    void deleteEmployeeById(@Param("id") Long id);

}
