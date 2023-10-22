package com.example.SecurityTransactions.resource;

import com.example.SecurityTransactions.entity.Employee;
import com.example.SecurityTransactions.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource (EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public List<Employee>  getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }
}
