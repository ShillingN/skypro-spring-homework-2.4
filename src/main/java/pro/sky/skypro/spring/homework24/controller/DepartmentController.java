package pro.sky.skypro.spring.homework24.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.service.DepartmentService;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all/{departmentId}")
    public List<Employee> printDepartmentEmployee(@PathVariable Integer departmentId) {
        return departmentService.printDepartmentEmployee(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> printAllEmployee() {
        return departmentService.printAllEmployee();
    }

    @GetMapping("/max-salary/{departmentId}")
    public Employee getMaxSalary(@PathVariable Integer departmentId) {
        return departmentService.getMaxSalary(departmentId);
    }

    @GetMapping("/min-salary/{departmentId}")
    public Employee getMinSalary(@PathVariable Integer departmentId) {
        return departmentService.getMinSalary(departmentId);
    }
}
