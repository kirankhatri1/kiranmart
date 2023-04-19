package com.kiranmart.kiranmart.employee;

import org.springframework.stereotype.Controller;

@Controller
public class EmployeeControllerImpl implements EmployeeController {

    @Override
    public String loadViewIndex() {
        return "employee/index";
    }
}
