package com.employeemanagement.controller.employee;

import com.employeemanagement.service.EmployeeService;
import com.employeemanagement.service.EmploymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeListController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmploymentDetailsService employmentDetailsService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listOfEmployees", employeeService.getAllEmployees());
        return "employee/employeeList";
    }

}
