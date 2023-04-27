package com.kiranmart.kiranmart.department;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("department")
@Controller
public interface DepartmentController {
    @GetMapping("")
    String loadViewIndex ( Model model);

    @PostMapping(value= "/create")
    public String addDepartment(@ModelAttribute Department department);
}
