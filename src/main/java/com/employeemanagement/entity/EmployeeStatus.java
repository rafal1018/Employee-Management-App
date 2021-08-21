package com.employeemanagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee_statuses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status_type")
    private String statusType;

}
