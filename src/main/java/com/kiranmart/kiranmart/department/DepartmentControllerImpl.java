package com.kiranmart.kiranmart.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

public class DepartmentControllerImpl implements DepartmentController{
    @Autowired
    DepartmentService departmentService;
    @Override
    public String loadViewIndex(Model model) {

        List<Department> departmentList = departmentService.findAllDepartment();
        model.addAttribute("deparmentList", departmentList);
        return "department/index";
    }

    @Override
    public String addDepartment(Department department) {
        return null;
    }
}
