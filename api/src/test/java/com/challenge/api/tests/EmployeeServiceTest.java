package com.challenge.api.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.challenge.api.model.Employee;
import com.challenge.api.repository.EmployeeRepository;
import com.challenge.api.service.EmployeeService;
import com.challenge.api.service.EmployeeServiceImpl;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.com.challenge.api.model.EmployeeImpl;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        // Creating a blank repository
        employeeRepository = new EmployeeRepository();
        employeeRepository.getEmployees().clear(); // Make sure it is clear
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void grabEmployeesTest() {
        // Add two employees to the repository
        Employee employee1 =
                new EmployeeImpl(UUID.randomUUID(), "Mike", "Cook", 50000, 53, "Janitor", "mikecook@reliaquest.com");
        Employee employee2 = new EmployeeImpl(
                UUID.randomUUID(), "Peter", "Long", 60000, 23, "Data Analyst", "peterlong@reliaquest.com");

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        // Invoke grabEmployees to return all employees
        List<Employee> employees = employeeService.grabEmployees();

        assertEquals(2, employees.size());

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }
    }

    @Test
    public void getEmployeeByIdTest() {
        // Add two employees to the repository
        Employee employee1 =
                new EmployeeImpl(UUID.randomUUID(), "Mike", "Cook", 50000, 53, "Janitor", "mikecook@reliaquest.com");
        Employee employee2 = new EmployeeImpl(
                UUID.randomUUID(), "Peter", "Long", 60000, 23, "Data Analyst", "peterlong@reliaquest.com");

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        // Invoke the getEmployeeByUuid to return employee based on their Uuid
        Employee employee = employeeService.getEmployeeWithUuid(employee2.getUuid());

        assertEquals(employee2.getUuid(), employee.getUuid());

        System.out.println(employee.getFirstName());
    }

    @Test
    public void createNewEmployeeTest() {
        // Create details for a new employee
        UUID uuid = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Smith";
        int salary = 100000;
        int age = 25;
        String jobTitle = "Developer";
        String email = "johnsmith@reliaquest.com";

        // Created new employee, saved it, and made sure it can pull the first name
        Employee newEmployee = new EmployeeImpl(uuid, firstName, lastName, salary, age, jobTitle, email);

        employeeRepository.save(newEmployee);

        assertEquals(newEmployee, employeeService.getEmployeeWithUuid(uuid));

        System.out.println(newEmployee.getFirstName());
    }
}
