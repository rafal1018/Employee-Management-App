package com.employeemanagement.controller.employee;

import com.employeemanagement.dto.EmployeeDTO;
import com.employeemanagement.entity.Employee;
import com.employeemanagement.entity.EmploymentDetails;
import com.employeemanagement.service.EmployeePositionsService;
import com.employeemanagement.service.EmployeeService;
import com.employeemanagement.service.EmployeeStatusesService;
import com.employeemanagement.service.EmploymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.TreeSet;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmploymentDetailsService employmentDetailsService;

    @Autowired
    private EmployeeStatusesService employeeStatusesService;

    @Autowired
    private EmployeePositionsService employeePositionsService;

    @GetMapping("/new-employee-form")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("positions", employeePositionsService.getAllPositions());
        model.addAttribute("statuses", employeeStatusesService.findAllStatuses());
        return "employee/employeeForm";
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO) {
        Employee employee = employeeService.getEmployeeFromEmployeeDTO(new Employee(), employeeDTO);

        EmploymentDetails employmentDetails = employmentDetailsService
                .getEmploymentDetailsFromEmployeeDTO(new EmploymentDetails(), employeeDTO);

        employee.setEmploymentDetails(employmentDetails);
        employmentDetails.setEmployee(employee);
        employeeService.saveEmployee(employee);
        employmentDetailsService.saveEmploymentDetails(employmentDetails);
        return "redirect:/";
    }

    @GetMapping("/update-employee-form")
    public String showFormUpdate(@RequestParam("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        EmploymentDetails employmentDetails = employee.getEmploymentDetails();
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployeeId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());

        employeeDTO.setSalary(employmentDetails.getSalary());
        employeeDTO.setPosition(employmentDetails.getEmployeePosition());
        employeeDTO.setHireDate(employmentDetails.getHireDate());
        employeeDTO.setEmploymentStatus(employmentDetails.getEmployeeStatus());
        employeeDTO.setResignationDate(employmentDetails.getResignationDate());

        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("positions", getEmployeePositions());
        model.addAttribute("statuses", getEmployeeStatuses());
        return "employee/employeeUpdateForm";
    }

    @PostMapping("/update-employee")
    public String updateEmployee(@ModelAttribute("employeeDTO") EmployeeDTO employeeDTO) {
        Employee employee = employeeService.getEmployeeFromEmployeeDTO(employeeService
                .getEmployeeById(employeeDTO.getEmployeeId()), employeeDTO);

        EmploymentDetails employmentDetails = employmentDetailsService
                .getEmploymentDetailsFromEmployeeDTO(employee.getEmploymentDetails(), employeeDTO);

        employee.setEmploymentDetails(employmentDetails);
        employmentDetails.setEmployee(employee);
        employeeService.saveEmployee(employee);
        employmentDetailsService.saveEmploymentDetails(employmentDetails);
        return "redirect:/";
    }

    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    private Set<String> getEmployeePositions() {
        Set<String> positions = new TreeSet<>();
        positions.add("CEO");
        positions.add("Project Manager");
        positions.add("Senior Java Developer");
        positions.add("Middle Java Developer");
        positions.add("Junior Java Developer");
        positions.add("DevOps");
        positions.add("HR Specialist");
        positions.add("Help Desk Specialist");
        return positions;
    }

    private Set<String> getEmployeeStatuses() {
        Set<String> statuses = new TreeSet<>();
        statuses.add("Hired");
        statuses.add("Unemployed");
        statuses.add("Vacation leave");
        statuses.add("Maternity leave");
        statuses.add("Unpaid leave");
        statuses.add("Sick leave");
        return statuses;
    }

}
