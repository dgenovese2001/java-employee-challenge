package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.repository.EmployeeRepository;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepos;

    public EmployeeServiceImpl(EmployeeRepository employeeRepos) {
        this.employeeRepos = employeeRepos;
    }

    // Return the employees from the data in the repository
    public List<Employee> grabEmployees() {
        return new ArrayList<>(employeeRepos.getEmployees().values());
    }

    // Grab the employee from the repository using the key of uuid
    public Employee getEmployeeWithUuid(UUID uuid) {
        return employeeRepos.getEmployees().get(uuid);
    }

    // Save the new employee object to the repository
    public Employee createNewEmployee(Employee newEmployee) {
        return employeeRepos.save(newEmployee);
    }
}
