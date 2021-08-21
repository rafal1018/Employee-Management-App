package com.employeemanagement.controller.position;

import com.employeemanagement.entity.EmployeePosition;
import com.employeemanagement.service.EmployeePositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeePositionController {

    @Autowired
    private EmployeePositionsService positionsService;

    @GetMapping("/new-position-form")
    public String showNewEmployeePositionForm(Model model) {
        model.addAttribute("employeePosition", new EmployeePosition());
        return "position/employeePositionForm";
    }

    @PostMapping("/save-position")
    public String savePosition(@ModelAttribute("employeePosition") EmployeePosition employeePosition) {
        positionsService.savePosition(employeePosition);
        return "redirect:/positions-list";
    }

    @GetMapping("/update-position-form")
    public String showFormUpdate(@RequestParam("id") Long id, Model model) {
        EmployeePosition position = positionsService.getPositionById(id);
        model.addAttribute("employeePosition", position);
        return "position/employeePositionFormUpdate";
    }

    @PostMapping("/update-position")
    public String updatePosition(@ModelAttribute("employeePosition") EmployeePosition employeePosition) {
        positionsService.savePosition(employeePosition);
        return "redirect:/positions-list";
    }

    @GetMapping("/delete-position")
    public String deletePosition(@RequestParam("id") Long id) {
        positionsService.deletePosition(id);
        return "redirect:/positions-list";
    }

}
