package com.employeemanagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee_positions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "position_type")
    private String positionType;

}
