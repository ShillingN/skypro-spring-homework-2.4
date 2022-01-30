package pro.sky.skypro.spring.homework24.service;

import pro.sky.skypro.spring.homework24.Employee;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);
}
