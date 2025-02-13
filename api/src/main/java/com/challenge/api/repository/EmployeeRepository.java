package src.main.java.com.challenge.api.repository;

import com.challenge.api.model.Employee;
import org.springframework.stereotype.Repository;
import src.main.java.com.challenge.api.model.EmployeeImpl;

import java.time.Instant;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeRepository {
    private final Map<UUID, Employee> employees = new HashMap<>();


    public EmployeeRepository() {


        employees.put(UUID.fromString("773eb883-13e7-4c85-81e9-4f6b08f3fb63"),new EmployeeImpl(UUID.fromString("773eb883-13e7-4c85-81e9-4f6b08f3fb63"), "Paul", "Blart", 80000, 56, "Security Guard", "paulblart@reliaquest.com"));
        employees.put(UUID.fromString("b01bd973-63bc-4b0e-a6bf-b54e03b484af"), new EmployeeImpl(UUID.fromString("b01bd973-63bc-4b0e-a6bf-b54e03b484af"), "John", "Jones", 130000, 31, "Senior Software Engineer", "johnjones@reliaquest.com"));
        employees.put(UUID.fromString("5c1fcc1f-f77e-4c67-a506-4ed6cd647d67"), new EmployeeImpl(UUID.fromString("5c1fcc1f-f77e-4c67-a506-4ed6cd647d67"), "Sarah", "Park", 70000, 26, "Recruiter", "sarahpark@reliaquest.com"));
    }

    public Map<UUID, Employee> getEmployees(){
        return employees;
    }

    public Employee save(Employee employee) {
        return employees.put(employee.getUuid(), employee);
    }
}

