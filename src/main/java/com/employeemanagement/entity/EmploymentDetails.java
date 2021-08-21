package com.employeemanagement.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employment_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EmploymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private EmployeePosition employeePosition;

    @Column(name = "hire_date")
    private String hireDate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private EmployeeStatus employeeStatus;

    @Column(name = "resignation_date")
    @Nullable
    private String resignationDate;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

}
