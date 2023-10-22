package com.example.SecurityTransactions.service;

import com.example.SecurityTransactions.entity.Employee;
import com.example.SecurityTransactions.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
