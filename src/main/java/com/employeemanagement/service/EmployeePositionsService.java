package com.employeemanagement.service;

import com.employeemanagement.entity.EmployeePosition;
import com.employeemanagement.repository.EmployeePositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePositionsService {

    @Autowired
    private EmployeePositionRepository repository;

    public void savePosition(EmployeePosition employeePosition) {
        repository.save(employeePosition);
    }

    public void deletePosition(Long id) {
        repository.deleteById(id);
    }

    public List<EmployeePosition> getAllPositions() {
        return repository.findAll();
    }

    public EmployeePosition getPositionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee position not found for id: " + id));
    }

}
