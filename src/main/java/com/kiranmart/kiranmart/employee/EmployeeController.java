package com.kiranmart.kiranmart.employee;

import com.kiranmart.kiranmart.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("employee")
@Controller
public interface EmployeeController {


    @GetMapping("")
    String loadViewIndex();

    @PostMapping(value = "saveupdate")
    ResponseEntity<Response> saveOrUpdate(@ModelAttribute Employee employee);

    @GetMapping(value = "find-all")
    ResponseEntity<Response> findAllData();

    @GetMapping("find-by-id")
    ResponseEntity<Response> findById(@RequestParam(value = "id") Long employeeId);

    @GetMapping("delete")
    ResponseEntity<Response> delete(@RequestParam(value = "id") Long employeeId);
}
