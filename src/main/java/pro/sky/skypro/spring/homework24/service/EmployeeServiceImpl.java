package pro.sky.skypro.spring.homework24.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.exception.EmployeeIsAlreadyOnTheListException;
import pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsValue(employee)) {
            throw new EmployeeIsAlreadyOnTheListException();
        }
            employeeList.put(employee.getFullName(), employee);
            System.out.println(employeeList.get(employee.getFullName()));
            return employee;

    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            return employeeList.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsKey(employee.getFullName())) {
            return  employeeList.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }
}
