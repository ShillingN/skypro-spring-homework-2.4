package pro.sky.skypro.spring.homework24.impl;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring.homework24.Employee;
import pro.sky.skypro.spring.homework24.exception.EmployeeStorageOverflowException;
import pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;
import pro.sky.skypro.spring.homework24.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Employee[] employees = new Employee[3];

    public Employee add(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, lastName);
                Employee employee = employees[i];
                return employee;
            }
        }
        throw new EmployeeStorageOverflowException();
    }

    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (firstName.equals(employees[i].getFirstName()) && (lastName.equals(employees[i].getLastName()))) {
                Employee employee = employees[i];
                employees[i] = null;
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (firstName.equals(employees[i].getFirstName()) && (lastName.equals(employees[i].getLastName()))) {
                Employee employee = employees[i];
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }


}
