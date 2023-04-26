package com.kiranmart.kiranmart.employee;

import com.kiranmart.kiranmart.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("employee")
@Controller
public interface EmployeeController {


    @GetMapping("")
    String loadViewIndex(Model model);

    @PostMapping(value = "saveupdate")
    ResponseEntity<Response> saveOrUpdate(@ModelAttribute Employee employee);

    @GetMapping("create")
    String addEmployee(Model model);

    @PostMapping("/create")
    public String addEmployee(@ModelAttribute Employee employee);

    @GetMapping(value = "find-all")
    ResponseEntity<Response> findAllData();

    @GetMapping("find-by-id")
    ResponseEntity<Response> findById(@RequestParam(value = "id") Long employeeId);

    @GetMapping("delete")
    ResponseEntity<Response> delete(@RequestParam(value = "id") Long employeeId);
}
