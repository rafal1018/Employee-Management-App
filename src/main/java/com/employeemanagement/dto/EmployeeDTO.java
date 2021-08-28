package com.employeemanagement.dto;

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

    private Long position;

    private Long employmentStatus;

    private String resignationDate;

}
