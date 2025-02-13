package src.main.java.com.challenge.api.service;

import com.challenge.api.model.Employee;


import java.util.List;
import java.util.UUID;


public interface EmployeeService {

    List<Employee> getEmployees();
    Employee getEmployeeByUuid(UUID uuid);
    Employee createEmployee(Employee employee);



}
