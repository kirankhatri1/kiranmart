package com.kiranmart.kiranmart.employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("employee")
@Controller
public interface EmployeeController {


    @GetMapping("")
    String loadViewIndex();

}
