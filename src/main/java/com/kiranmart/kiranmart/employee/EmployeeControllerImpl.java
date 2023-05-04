package com.kiranmart.kiranmart.employee;


import com.kiranmart.kiranmart.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Override
    public String loadViewIndex(Model model) {

        List<Employee> employeeList = employeeService.findAllEmployee();

        model.addAttribute("employeeList", employeeList);
        return "employee/index";
    }

    public ResponseEntity<Response> saveOrUpdate(Employee employee) {

        boolean update = employee.getId() != null;
        String message = "";

        if(update){
            employee.setModifiedDate(new Date());
        } else
            employee.setCreatedDate(new Date());

        boolean success = employeeService.saveEmployee(employee);

        if(success && update)
            message = "Updated successfully";
        else if(success)
            message = "Saved successfully";
        else
            message = "operation Faield";

        return ResponseEntity.ok(new Response(success, message, employee));
    }

    @Override
    public String addEmployee(Model model) {
        return "employee/new-employee";
    }

    @Override
    public String editEmployee(Model model, Long employeeId) {

        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @Override
    public String addEmployee(Employee employee) {
        log.info("add employee page");
        employee.setCreatedDate(new Date());
        employeeService.saveEmployee(employee);
        log.info("Employee added");
        return "redirect:/employee";
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

    @Override
    public ResponseEntity<Response> findAllByStatus() {
        boolean success = false;
        String message;
        List<Employee> employeeList = null;

        try{
            employeeList = employeeService.findAllByStatus();
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
        Employee employee = null;

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
    public String delete(Long employeeId) {

        boolean success = false;
        String message;

        try {
            employeeService.deleteEmployeeById(employeeId);
            success = true;
            message = "Deleted employee successfully.";
        } catch (Exception e){
            e.printStackTrace();
            message = "Something went wrong";
        }

        return "redirect:/employee";
    }
}
