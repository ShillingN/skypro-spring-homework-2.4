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
    public List<Employee> printDepartmentEmployee(@PathVariable("departmentId") Integer departmentId) {
        return departmentService.printDepartmentEmployee(departmentId);
    }

    @GetMapping("/max-salary/{departmentId}")
    public Employee getMaxSalary(@PathVariable("departmentId") Integer departmentId) {
        return departmentService.getMaxSalary(departmentId).orElseThrow();
    }

    @GetMapping("/min-salary/{departmentId}")
    public Employee getMinSalary(@PathVariable("departmentId") Integer departmentId) {
        return departmentService.getMinSalary(departmentId).orElseThrow();
    }
}
