package com.kiranmart.kiranmart.employee;

import java.util.List;

public interface EmployeeRepositoryCustom {


    Employee findEmployeeById(Long id);

    List<Employee> findAllByStatus();

//    boolean deleteEmployeeById(Long id);

}
