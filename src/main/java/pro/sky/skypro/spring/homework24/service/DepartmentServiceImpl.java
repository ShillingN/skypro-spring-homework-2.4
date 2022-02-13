package pro.sky.skypro.spring.homework24.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getMaxSalary(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getMinSalary(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> printDepartmentEmployee(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .sorted(Comparator.comparing(Employee::getFullName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> printAllEmployee() {
        return employeeService.getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getFullName))
                .collect(Collectors.toList());
    }
}
