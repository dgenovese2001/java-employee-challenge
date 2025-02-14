package src.main.java.com.challenge.api.model;

import com.challenge.api.model.Employee;
import java.time.Instant;
import java.util.UUID;

// Implementing the getters and setters from the employee instance
public class EmployeeImpl implements Employee {

    private UUID uuid;

    private String firstName;

    private String lastName;

    private String fullName;

    private Integer salary;

    private Integer age;

    private String jobTitle;

    private String email;

    private Instant contractHireDate;

    private Instant contractTerminationDate;

    public EmployeeImpl(
            UUID uuid, String firstName, String lastName, Integer salary, Integer age, String jobTitle, String email) {

        this.uuid = uuid;

        this.firstName = firstName;

        this.lastName = lastName;

        this.fullName = firstName + " " + lastName;

        this.salary = salary;

        this.age = age;

        this.jobTitle = jobTitle;

        this.email = email;

        this.contractHireDate = Instant.now();

        this.contractTerminationDate = null;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(UUID uuid) {}

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String name) {}

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String name) {}

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void setFullName(String name) {}

    @Override
    public Integer getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Integer salary) {}

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {}

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {}

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {}

    @Override
    public Instant getContractHireDate() {
        return Instant.now();
    }

    @Override
    public void setContractHireDate(Instant date) {}

    @Override
    public Instant getContractTerminationDate() {
        return null;
    }

    @Override
    public void setContractTerminationDate(Instant date) {}
}
