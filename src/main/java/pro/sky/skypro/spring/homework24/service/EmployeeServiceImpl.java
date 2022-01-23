package pro.sky.skypro.spring.homework24.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeList.add(employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int index = employeeList.indexOf(employee);
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return employeeList.remove(index);
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee) == true) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
}
