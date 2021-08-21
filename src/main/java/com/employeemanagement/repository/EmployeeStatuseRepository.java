package com.employeemanagement.repository;

import com.employeemanagement.entity.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeStatuseRepository extends JpaRepository<EmployeeStatus, Long> {

}
