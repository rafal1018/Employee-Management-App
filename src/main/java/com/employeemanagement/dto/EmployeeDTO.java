package com.employeemanagement.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class EmployeeDTO {

    private long employeeId;

    @NotEmpty(message = "Must no be empty")
    @Size(min = 2, message = "The first name should be at least 2 characters long")
    private String firstName;

    @NotEmpty(message = "Must not be empty")
    @Size(min = 2, message = "The last name should be at least 2 characters long")
    private String lastName;

    @NotEmpty(message = "Must not be empty")
    @Email
    private String email;

    @NotNull(message = "Must not be empty")
    private BigDecimal salary;

    @NotEmpty(message = "Must not be empty")
    private String hireDate;

    @NotNull(message = "Must not be empty")
    private Long position;

    @NotNull(message = "Must not be empty")
    private Long employmentStatus;

    private String resignationDate;

}
