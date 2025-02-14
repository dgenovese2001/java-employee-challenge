package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import src.main.java.com.challenge.api.model.EmployeeImpl;

// Created a Mock data repository with a way to save new data and get the data also
@Repository
public class EmployeeRepository {
    private final Map<UUID, Employee> employees = new HashMap<>();

    public EmployeeRepository() {
        employees.put(
                UUID.fromString("773eb883-13e7-4c85-81e9-4f6b08f3fb63"),
                new EmployeeImpl(
                        UUID.fromString("773eb883-13e7-4c85-81e9-4f6b08f3fb63"),
                        "Paul",
                        "Blart",
                        80000,
                        56,
                        "Security Guard",
                        "paulblart@reliaquest.com"));
        employees.put(
                UUID.fromString("b01bd973-63bc-4b0e-a6bf-b54e03b484af"),
                new EmployeeImpl(
                        UUID.fromString("b01bd973-63bc-4b0e-a6bf-b54e03b484af"),
                        "John",
                        "Jones",
                        130000,
                        31,
                        "Senior Software Engineer",
                        "johnjones@reliaquest.com"));
        employees.put(
                UUID.fromString("5c1fcc1f-f77e-4c67-a506-4ed6cd647d67"),
                new EmployeeImpl(
                        UUID.fromString("5c1fcc1f-f77e-4c67-a506-4ed6cd647d67"),
                        "Sarah",
                        "Park",
                        70000,
                        26,
                        "Recruiter",
                        "sarahpark@reliaquest.com"));
    }

    // Returning a map of the employees with the UUID as the key
    public Map<UUID, Employee> getEmployees() {
        return employees;
    }

    // Allows the new employee to be saved to the repository
    public Employee save(Employee employee) {
        return employees.put(employee.getUuid(), employee);
    }
}
