package pro.sky.skypro.spring.homework24.service;

import pro.sky.skypro.spring.homework24.data.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Optional<Employee> getMaxSalary(int departmentId);

    Optional<Employee> getMinSalary(int departmentId);

    List<Employee> printDepartmentEmployee(int departmentId);


}
