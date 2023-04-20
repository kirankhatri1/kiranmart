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
    ResponseEntity<Response> saveOrUpdate(@ModelAttribute Employee employee,
                                          @RequestParam(value = "id", required = false) Long id);

    @PostMapping(value = "find-all")
    public ResponseEntity<Response> findAllData();

}
