package com.kiranmart.kiranmart.employee;


import com.kiranmart.kiranmart.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Override
    public String loadViewIndex() {
        return "employee/index";
    }


    public ResponseEntity<Response> saveOrUpdate(Employee employee) {

        boolean update = employee.getId() != null;
        String message = "";
        boolean success = employeeService.saveEmployee(employee);

        if(success){
            if(update)
                message = "Updated successfully";
            else
            message = "Saved successfully";
        } else message ="operation failed";

        return ResponseEntity.ok(new Response(success, message, employee));
    }

    public ResponseEntity<Response> findAllData() {

        boolean success = false;
        String message;
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

    public ResponseEntity<Response> findById(Long employeeId) {

        boolean success = false;
        String message;
        Optional<Employee> employee = null;

        try {
            employee = employeeService.findById(employeeId);
            success = true;
            message = "Fetched data successfully.";
        } catch (Exception e){
            e.printStackTrace();
            message = "Something went wrong";
        }

        return ResponseEntity.ok(new Response(success, message, employee));
    }

    @Override
    public ResponseEntity<Response> delete(Long employeeId) {

        boolean success = false;
        String message;

        try {
            employeeService.deleteEmployee(employeeId);
            success = true;
            message = "Deleted employee successfully.";
        } catch (Exception e){
            e.printStackTrace();
            message = "Something went wrong";
        }

        return ResponseEntity.ok(new Response(success, message, null));
    }
}
