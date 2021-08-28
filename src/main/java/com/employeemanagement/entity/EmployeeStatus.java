package com.employeemanagement.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EM_STATUSES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "status_type")
    @NotEmpty(message = "Must not be empty")
    @Size(min = 2, message = "The first name should be at least 2 characters long")
    private String statusType;

}
