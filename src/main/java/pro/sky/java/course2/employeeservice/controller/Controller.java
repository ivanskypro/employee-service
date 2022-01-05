package pro.sky.java.course2.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {

    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в сервис по работе с работниками!";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.add(firstName, lastName);
        return result + "успешно создан";
    }

    @GetMapping("/remove")
    public String eraseEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.remove(firstName, lastName);
        return result + " удалён";
    }

    @GetMapping("/get")
    public List<Employee> printArray () {
        List<Employee> result = employeeService.print();
        return result;
    }
    @GetMapping("/size")
    public int getSize () {
        int result = employeeService.size();
        return result;}

    @GetMapping("/find")
    public String findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.find(firstName, lastName);
        return result + "найден";

    }

}
