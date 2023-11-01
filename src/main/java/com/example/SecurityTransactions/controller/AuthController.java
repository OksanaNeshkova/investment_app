//package com.example.SecurityTransactions.controller;
//
//import com.example.SecurityTransactions.dto.LoginDto;
//import com.example.SecurityTransactions.dto.RegisterDto;
//import com.example.SecurityTransactions.entity.Employee;
//import com.example.SecurityTransactions.repo.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//public class AuthController {
//
//    private AuthenticationManager authenticationManager;
//    private EmployeeRepository employeeRepository;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public AuthController(AuthenticationManager authenticationManager, EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
//        this.authenticationManager = authenticationManager;
//        this.employeeRepository = employeeRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
//        if (employeeRepository.existsByEmail(registerDto.getEmail())) {
//            return new ResponseEntity<>("Employee with this email already exists", HttpStatus.BAD_REQUEST);
//        }
//        Employee employee = new Employee();
//        employee.setFirstName(registerDto.getFirstName());
//        employee.setLastName(registerDto.getLastName());
//        employee.setPersonalCode(registerDto.getPersonalCode());
//        employee.setPhone(registerDto.getPhone());
//        employee.setEmail(registerDto.getEmail());
//        employee.setAddress(registerDto.getAddress());
//        employee.setPassword(passwordEncoder.encode(registerDto.getPassword()));
//        employee.setRole(registerDto.getRole());
//
//        employeeRepository.save(employee);
//        return new ResponseEntity<>("New employee registered successfully", HttpStatus.OK);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
//        System.out.println(loginDto.getEmail());
//        System.out.println(loginDto.getPassword());
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        System.out.println("Response sent successfully");
//        return new ResponseEntity<>("Signed success!",HttpStatus.OK);
//    }
//
//}
