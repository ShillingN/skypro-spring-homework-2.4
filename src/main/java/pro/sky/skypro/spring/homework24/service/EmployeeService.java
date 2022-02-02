package pro.sky.skypro.spring.homework24.service;

import pro.sky.skypro.spring.homework24.data.Employee;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(Integer id);

    Employee find(Integer id);
}
