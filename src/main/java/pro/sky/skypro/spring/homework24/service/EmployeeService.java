package pro.sky.skypro.spring.homework24.service;

import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;

public interface EmployeeService {
    pro.sky.skypro.spring.homework24.data.Employee add(String firstName, String lastName);

    pro.sky.skypro.spring.homework24.data.Employee remove(String firstName, String lastName) throws pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;

    Employee find(String firstName, String lastName) throws EmployeeNotFoundException;
}
