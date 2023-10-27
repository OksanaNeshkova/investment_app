//package com.example.SecurityTransactions.resource;
//
//import com.example.SecurityTransactions.entity.Employee;
//import com.example.SecurityTransactions.entity.Role;
//import com.example.SecurityTransactions.dto.RegisterDto;
//import com.example.SecurityTransactions.repo.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/auth")
//public class AuthResource {
//
//    private AuthenticationManager authenticationManager;
//    private EmployeeRepository employeeRepository;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public AuthResource(AuthenticationManager authenticationManager, EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
//        this.authenticationManager = authenticationManager;
//        this.employeeRepository = employeeRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity <String> register(@RequestBody RegisterDto registerDto){
//        if(employeeRepository.existsByEmail(registerDto.getEmail())){
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
//        employee.setRole(Role.USER);
//
//        employeeRepository.save(employee);
//        return new ResponseEntity<>("New employee registered successfully",HttpStatus.OK);
//    }
//
//}
