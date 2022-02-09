package pro.sky.skypro.spring.homework24.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring.homework24.data.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee> getMaxSalary(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> getMinSalary(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public List<Employee> printDepartmentEmpl(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }
}
