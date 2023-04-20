package com.kiranmart.kiranmart.employee;


import com.kiranmart.kiranmart.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Override
    public String loadViewIndex() {
        return "employee/index";
    }

    @Override
    public ResponseEntity<Response> saveOrUpdate(Employee employee, Long id) {

        String message = "";
        boolean success = employeeService.saveEmployee(employee);

        if(success){
            message = "Saved successfully";
        } else message ="failed to save";

        return ResponseEntity.ok(new Response(success, message, employee));
    }

    @Override
    public ResponseEntity<Response> findAllData() {

        boolean success = false;
        String message = null;
        List<Employee> employeeList = null;

        try{
            employeeList = employeeService.findAllEmployee();
            success = true;
            long dataCount = employeeList.size();
            message = "Fetched " + dataCount + " data successfully.";
        } catch (Exception e){
            e.printStackTrace();
            message = "Something went wrong";
        }

        return ResponseEntity.ok(new Response(success, message, employeeList));
    }
}
