package com.kiranmart.kiranmart.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    void saveEmployee(Employee employee){
        log.info("before saving employee");
        employeeRepository.save(employee);
        log.info("Employee saved successfully");
    }



}
