//package com.example.SecurityTransactions.service;
//
//import com.example.SecurityTransactions.entity.Employee;
//import com.example.SecurityTransactions.entity.Role;
//import com.example.SecurityTransactions.exception.BadRequestException;
//import com.example.SecurityTransactions.repo.EmployeeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.ArrayList;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class EmployeeServiceTest {
//    @Mock
//    private EmployeeRepository employeeRepository;
//    @Mock
//    private PasswordEncoder passwordEncoder;
//    @InjectMocks
//    private EmployeeService underTest;
//
//    @BeforeEach
//    void setup(){
//        underTest = new EmployeeService(employeeRepository, passwordEncoder);
//    }
//
//
//    @Test
//    void canGetAllEmployees(){
//        underTest.findAllEmployees();
//        verify(employeeRepository).findAll();
//    }
//
//
//    @Test
//    void canAddEmployee() {
//        //Given
//        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setFirstName("Pedro");
//        employee.setLastName("Reis");
//        employee.setPassword("root");
//        employee.setPersonalCode(123456789);
//        employee.setEmail("pedrocarepas@gmail.com");
//        employee.setAddress("Ravi tee 11");
//        employee.setPhone("95564523");
//        employee.setRole(Role.ROLE_ADMIN);
//        when(passwordEncoder.encode("root")).thenReturn("encodedPassword");
//
//        //When
//        underTest.addEmployee(employee);
//        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
//        verify(employeeRepository).save(employeeArgumentCaptor.capture());
//        Employee capturedEmployee = employeeArgumentCaptor.getValue();
//
//        //Then
//        assertThat(capturedEmployee).isEqualTo(employee);
//        assertThat(capturedEmployee.getPassword()).isEqualTo("encodedPassword");
//    }
//
//}
