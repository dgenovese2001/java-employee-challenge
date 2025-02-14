package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Fill in the missing aspects of this Spring Web REST Controller. Don't forget to add a Service layer.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee models as necessary.
     * @return One or more Employees.
     */
    private final EmployeeService employeesService;

    public EmployeeController(EmployeeService employeesService) {
        this.employeesService = employeesService;
    }

    // Create a list from the data grabbed and throw an exception if no employees are found
    @GetMapping
    public List<Employee> getAllEmployees() {
        List<Employee> employee = employeesService.grabEmployees();
        if (employee == null || employee.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "No Employees found");
        }
        return employee;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */

    /*Grabbing employee by UUID if they don't exist, and it returns null then it will
    throw an exception*/
    @GetMapping(value = "/{uuid}")
    public Employee getEmployeeByUuid(UUID uuid) {
        if (uuid == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UUID parameter cannot be null");
        }

        Employee employee = employeesService.getEmployeeWithUuid(uuid);

        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }

        return employee;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer.
     * @param requestBody hint!
     * @return Newly created Employee
     */
    // Returning a new employee based off the object that is given
    @PostMapping
    public Employee createEmployee(Object requestBody) {
        // If the requestBody is null it will throw an exception
        if (requestBody == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body cannot be null");
        }

        return employeesService.createNewEmployee((Employee) requestBody);
    }
}
