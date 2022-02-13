package pro.sky.skypro.spring.homework24.service;

import pro.sky.skypro.spring.homework24.data.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Employee add(String firstName, String lastName, Integer department, Integer salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Set<Employee> getEmployees();
}
