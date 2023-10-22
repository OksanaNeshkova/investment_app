package com.example.SecurityTransactions.resource;

import com.example.SecurityTransactions.entity.Employee;
import com.example.SecurityTransactions.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource (EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }
}
