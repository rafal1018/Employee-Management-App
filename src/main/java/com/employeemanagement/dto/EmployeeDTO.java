package com.employeemanagement.dto;

import com.employeemanagement.entity.EmployeePosition;
import com.employeemanagement.entity.EmployeeStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeDTO {

    private long employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private BigDecimal salary;

    private String hireDate;

    private EmployeePosition position;

    private EmployeeStatus employmentStatus;

    private String resignationDate;

}
