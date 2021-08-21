package com.employeemanagement.service;

import com.employeemanagement.entity.EmployeeStatus;
import com.employeemanagement.repository.EmployeeStatuseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeStatusesService {

    @Autowired
    private EmployeeStatuseRepository repository;

    public void saveStatus(EmployeeStatus employeeStatus) {
        repository.save(employeeStatus);
    }

    public void deleteStatus(Long id) {
        repository.deleteById(id);
    }

    public EmployeeStatus getStatusById(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee status not found for id: " + id));
    }

    public List<EmployeeStatus> findAllStatuses() {
        return repository.findAll();
    }

}
