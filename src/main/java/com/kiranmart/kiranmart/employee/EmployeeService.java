package com.kiranmart.kiranmart.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    boolean saveEmployee(Employee employee){
        log.info("before saving employee");
        try{
            employeeRepository.save(employee);
            log.info("Employee saved successfully");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    List<Employee> findAllEmployee(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long employeeId) {
        return Optional.ofNullable(employeeRepository.findEmployeeById(employeeId));
    }

    List<Employee> findAllByStatus(){
        return employeeRepository.findAllByStatus();
    }

    void deleteEmployeeById(Long id){
        employeeRepository.deleteEmployeeById(id);
    }

}
