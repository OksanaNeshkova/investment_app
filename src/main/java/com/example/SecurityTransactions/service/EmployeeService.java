package com.example.SecurityTransactions.service;

import com.example.SecurityTransactions.entity.Employee;
import com.example.SecurityTransactions.entity.Share;
import com.example.SecurityTransactions.exception.EmployeeNotFoundException;
import com.example.SecurityTransactions.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by ID " + id + " was not found."));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee findEByTransactionId (Long transId){
        List<Employee>employees = employeeRepository.findAll();
        Optional<Employee> optionalEmployee = employees.stream()
                .filter(emp -> emp.getTransaction().stream()
                        .anyMatch(transaction -> transaction.getId().equals(transId)))
                .findFirst();
        return optionalEmployee.orElse(null);
    }
}
