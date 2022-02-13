package pro.sky.skypro.spring.homework24.service;

import pro.sky.skypro.spring.homework24.data.Employee;

import java.util.List;

public interface DepartmentService {
    Employee getMaxSalary(int departmentId);

    Employee getMinSalary(int departmentId);

    List<Employee> printDepartmentEmployee(int departmentId);

    List<Employee> printAllEmployee();
}
