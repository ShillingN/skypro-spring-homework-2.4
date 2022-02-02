package pro.sky.skypro.spring.homework24.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.exception.EmployeeIsAlreadyOnTheListException;
import pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Integer, Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new HashMap<>();
    }

    Integer nextId = 0;

    private Integer getNextId() {
        Integer result = nextId;
        nextId++;
        return result;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.containsValue(employee)) {
            throw new EmployeeIsAlreadyOnTheListException();
        } else {
            employeeList.put(getNextId(), employee);
            System.out.println(employeeList.get(0));
            return employee;
        }
    }

    @Override
    public Employee remove(Integer id) {
        if (employeeList.containsKey(id)) {
            return employeeList.remove(id);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(Integer id) {
        if (employeeList.containsKey(id)) {
            return  employeeList.get(id);
        }
        throw new EmployeeNotFoundException();
    }
}
