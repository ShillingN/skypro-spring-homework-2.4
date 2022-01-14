package pro.sky.skypro.spring.homework24.impl;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring.homework24.service.EmployeeService;
import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;
import pro.sky.skypro.spring.homework24.exception.EmployeeStorageOverflowException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.add(employee)) {
            return employee;
        }
        throw new EmployeeStorageOverflowException();
    }


    public pro.sky.skypro.spring.homework24.data.Employee remove(String firstName, String lastName) throws pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException {
        pro.sky.skypro.spring.homework24.data.Employee employee = new pro.sky.skypro.spring.homework24.data.Employee(firstName, lastName);
        int index = employeeList.indexOf(employee);
        if (index == -1) {
            throw new pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException();
        }
        return employeeList.remove(index);
    }



    public pro.sky.skypro.spring.homework24.data.Employee find(String firstName, String lastName) throws pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException {
        pro.sky.skypro.spring.homework24.data.Employee employee = new Employee(firstName, lastName);
        if (firstName.equals(employee.getFirstName()) && (lastName.equals(employee.getLastName()))) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

}
