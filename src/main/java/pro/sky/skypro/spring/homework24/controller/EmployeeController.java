package pro.sky.skypro.spring.homework24.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.exception.IncorrectCharacterException;
import pro.sky.skypro.spring.homework24.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String helloMessage() {
        return "Привет! Вы находитесь в книге сотрудников.";
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam Integer department,
                            @RequestParam Integer salary) {
        if (StringUtils.isAlphaSpace(firstName + lastName)) {
            return employeeService.add(StringUtils.capitalize(firstName),StringUtils.capitalize(lastName), department, salary);
        }
        throw new IncorrectCharacterException();
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                               @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                             @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/all")
    public List<Employee> printDepartmentEmployee() {
        return employeeService.getAllEmployees();
    }

}
