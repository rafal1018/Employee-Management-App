package com.employeemanagement.service;

import com.employeemanagement.dto.EmployeeDTO;
import com.employeemanagement.entity.EmploymentDetails;
import com.employeemanagement.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmploymentDetailsService {

    @Autowired
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Autowired
    private EmployeeStatusService statusService;

    @Autowired
    private EmployeePositionService positionService;

    public void saveEmploymentDetails(EmploymentDetails employmentDetails) {
        employeeDetailsRepository.save(employmentDetails);
    }

    public EmploymentDetails findEmploymentDetailsById(Long id) {
        return employeeDetailsRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee details not found for id: " + id));
    }

    public EmploymentDetails getEmploymentDetailsFromEmployeeDTO(EmploymentDetails employmentDetails, EmployeeDTO employeeDTO) {
        employmentDetails.setSalary(employeeDTO.getSalary());
        employmentDetails.setEmployeePosition(positionService.getPositionById(employeeDTO.getPosition()));
        employmentDetails.setHireDate(employeeDTO.getHireDate());
        employmentDetails.setEmployeeStatus(statusService.getStatusById(employeeDTO.getEmploymentStatus()));
        employmentDetails.setResignationDate(employeeDTO.getResignationDate().isEmpty() ? null : employeeDTO.getResignationDate());
        return employmentDetails;
    }

}
