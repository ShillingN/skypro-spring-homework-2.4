package pro.sky.skypro.spring.homework24.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.skypro.spring.homework24.data.Employee;
import pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException;
import pro.sky.skypro.spring.homework24.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final pro.sky.skypro.spring.homework24.service.EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String helloMessage() {
        return "Привет! Вы находитесь в книге сотрудников.";
    }

    @GetMapping("/add")
    public pro.sky.skypro.spring.homework24.data.Employee addEmpl(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public pro.sky.skypro.spring.homework24.data.Employee removeEmpl(@RequestParam String firstName, @RequestParam String lastName) throws pro.sky.skypro.spring.homework24.exception.EmployeeNotFoundException {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmpl(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.find(firstName, lastName);
    }
}
