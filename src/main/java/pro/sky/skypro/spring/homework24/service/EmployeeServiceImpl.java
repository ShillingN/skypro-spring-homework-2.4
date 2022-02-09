package pro.sky.skypro.spring.homework24.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.exception.EmployeeIsAlreadyOnTheListException;
import pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new HashMap<>();
        employeeList.put("Дмитрий Смирнов", new Employee("Дмитрий", "Смирнов", 1, 230_000));
        employeeList.put("Антон Петров", new Employee("Антон", "Петров", 1, 240_000));
        employeeList.put("Алексей Чернышов", new Employee("Алексей", "Чернышов", 2, 250_000));
        employeeList.put("Владимир Морозов", new Employee("Владимир", "Морозов", 3, 260_000));
        employeeList.put("Ольга Ганина", new Employee("Ольга", "Ганина", 4, 270_000));
    }

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    @Override
    public Employee add(String firstName, String lastName, Integer department, Integer salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employeeList.containsValue(employee)) {
            throw new EmployeeIsAlreadyOnTheListException();
        } else {
            employeeList.put(getEmployeeKey(firstName, lastName), employee);
            return employee;
        }
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        if (employeeList.containsKey(getEmployeeKey(firstName, lastName))) {
            return employeeList.remove(getEmployeeKey(firstName, lastName));
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        if (employeeList.containsKey(getEmployeeKey(firstName, lastName))) {
            return employeeList.get(getEmployeeKey(firstName, lastName));
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Set<Employee> getEmployees() {
        return new HashSet<>(employeeList.values());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return getEmployees().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
