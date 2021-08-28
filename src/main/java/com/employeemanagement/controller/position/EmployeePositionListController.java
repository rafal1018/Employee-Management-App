package com.employeemanagement.controller.position;

import com.employeemanagement.service.EmployeePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeePositionListController {

    @Autowired
    private EmployeePositionService positionsService;

    @GetMapping("/positions-list")
    public String showPositionsList(Model model) {
        model.addAttribute("listOfPositions", positionsService.getAllPositions());
        return "position/employeePositionsList";
    }

}
