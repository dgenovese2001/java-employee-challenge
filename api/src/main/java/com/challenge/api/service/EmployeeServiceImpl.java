package src.main.java.com.challenge.api.service;


import com.challenge.api.model.Employee;
import src.main.java.com.challenge.api.model.EmployeeImpl;
import src.main.java.com.challenge.api.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepos;

    public EmployeeServiceImpl(EmployeeRepository employeeRepos){
        this.employeeRepos = employeeRepos;
    }
    public List<Employee> getEmployees() {
        return new ArrayList<>(employeeRepos.getEmployees().values());
    }

    public Employee getEmployeeUuid(UUID uuid) {
        return employeeRepos.getEmployees().get(uuid);
    }

    public Employee createEmployee(Employee newEmployee){
        return employeeRepos.save(newEmployee);
    }
}
