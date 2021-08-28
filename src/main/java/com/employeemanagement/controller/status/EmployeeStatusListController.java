package com.employeemanagement.controller.status;

import com.employeemanagement.service.EmployeeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeStatusListController {

    @Autowired
    private EmployeeStatusService statusService;

    @GetMapping("/status-list")
    public String showStatusesList(Model model) {
        model.addAttribute("listOfStatuses", statusService.findAllStatuses());
        return "status/employeeStatusList";
    }

}
