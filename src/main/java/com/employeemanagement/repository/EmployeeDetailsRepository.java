package com.employeemanagement.repository;

import com.employeemanagement.entity.EmploymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmploymentDetails, Long> {
}
