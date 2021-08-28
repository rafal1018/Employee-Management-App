package com.employeemanagement.controller.status;

import com.employeemanagement.entity.EmployeeStatus;
import com.employeemanagement.service.EmployeeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeStatusController {

    @Autowired
    private EmployeeStatusService statusService;

    @GetMapping("/new-status-form")
    public String showNewEmployeeStatusForm(Model model) {
        model.addAttribute("employeeStatus", new EmployeeStatus());
        return "status/employeeStatusForm";
    }

    @PostMapping("/save-status")
    public String saveStatus(@ModelAttribute("employeeStatus") EmployeeStatus employeeStatus) {
        statusService.saveStatus(employeeStatus);
        return "redirect:/status-list";
    }

    @GetMapping("/update-status-form")
    public String showFormUpdate(@RequestParam("id") Long id, Model model) {
        EmployeeStatus status = statusService.getStatusById(id);
        model.addAttribute("employeeStatus", status);
        return "status/employeeStatusFormUpdate";
    }

    @PostMapping("/update-status")
    public String updatePosition(@ModelAttribute("employeeStatus") EmployeeStatus employeeStatus) {
        statusService.saveStatus(employeeStatus);
        return "redirect:/status-list";
    }

    @GetMapping("/delete-status")
    public String deleteStatus(@RequestParam("id") Long id) {
        statusService.deleteStatus(id);
        return "redirect:/status-list";
    }

}
