package com.example.SecurityTransactions.repo;

import com.example.SecurityTransactions.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    @AfterEach
    void tearDown(){
        employeeRepository.deleteAll();
    }
    @Test
    public void canFindEmployeeById() {
        //Given
        Employee employee = new Employee();
        employee.setFirstName("Pedro");
        employee.setLastName("Reis");
        employee.setPassword("root");
        employee.setPersonalCode(111222333L);
        employee.setEmail("pedroreis@example.com");
        employee.setAddress("Ravi tee");
        employee.setPhone("111-222-4365");

        //Saving the employee to the database
        employeeRepository.save(employee);

        //When
        Long employeeId = employee.getId();
        Optional<Employee> foundEmployee = employeeRepository.findEmployeeById(employeeId);

        //Then
        assertTrue(foundEmployee.isPresent());
        assertEquals(employee.getFirstName(), foundEmployee.get().getFirstName());
        assertEquals(employee.getLastName(), foundEmployee.get().getLastName());
        assertEquals(employee.getPassword(), foundEmployee.get().getPassword());
        assertEquals(employee.getPersonalCode(), foundEmployee.get().getPersonalCode());
        assertEquals(employee.getEmail(), foundEmployee.get().getEmail());
        assertEquals(employee.getAddress(), foundEmployee.get().getAddress());
        assertEquals(employee.getPhone(), foundEmployee.get().getPhone());
    }

    @Test
    public void canFindByEmail() {
        //Given
        Employee employee = new Employee();
        employee.setFirstName("Pedro");
        employee.setLastName("Reis");
        employee.setPassword("root");
        employee.setPersonalCode(111222333L);
        employee.setEmail("pedroreis@example.com");
        employee.setAddress("Ravi tee");
        employee.setPhone("111-222-4365");

        //Saving the employee to the database
        employeeRepository.save(employee);

        //When
        String employeeEmail = employee.getEmail();
        Optional<Employee> foundEmployee = employeeRepository.findByEmail(employeeEmail);

        //Then
        assertTrue(foundEmployee.isPresent());
        assertEquals(employee.getEmail(), foundEmployee.get().getEmail());
    }

    @Test
    public void itShouldCheckWhenStudentEmailExists() {
        //Given
        String email = "pedroreis@example.com";
        Employee employee = new Employee();
        employee.setFirstName("Pedro");
        employee.setLastName("Reis");
        employee.setPassword("root");
        employee.setPersonalCode(111222333L);
        employee.setEmail(email);
        employee.setAddress("Ravi tee");
        employee.setPhone("111-222-4365");

        //Saving the employee to the database
        employeeRepository.save(employee);

        //When
        boolean expected = employeeRepository.existsByEmail(email);

        //Then
        assertThat(expected).isTrue();
    }




}