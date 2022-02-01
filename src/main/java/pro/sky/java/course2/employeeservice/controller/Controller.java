package pro.sky.java.course2.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.DepartmentService;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public Controller(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в сервис по работе с работниками!";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                              @RequestParam long salary,@RequestParam Integer department ) {
        Employee result = employeeService.add(firstName, lastName, salary, department);
        return result + "успешно создан";
    }

    @GetMapping("/remove")
    public String eraseEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam long salary, @RequestParam Integer department) {
        Employee result = employeeService.remove(firstName, lastName, salary, department);
        return result + " удалён";
    }

    @GetMapping("/get")
    public List<Employee> printArray () {
        List<Employee> result = employeeService.getAllEmployees();
        return result;
    }
    @GetMapping("/size")
    public int getSize () {
        int result = employeeService.size();
        return result;
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam String firstName, @RequestParam String lastName,
                               @RequestParam long salary, @RequestParam Integer department) {
        Employee result = employeeService.find(firstName, lastName, salary, department);
        return result + "найден";
    }

    @GetMapping ("/department/min-salary")
    public Employee printMinSalary (@RequestParam Integer department) {
        Employee result = departmentService.findMinSalary(department);
        return result;
    }

    @GetMapping ("/department/max-salary")
    public Employee printMaxSalary (@RequestParam Integer department) {
        Employee result = departmentService.findMaxSalary(department);
        return result;
    }

    @GetMapping("/department/all")
    public Collection<Employee> printDepartment(@RequestParam Integer department) {
        Collection<Employee> result = departmentService.printDepartment(department);
        return result;
    }

}
