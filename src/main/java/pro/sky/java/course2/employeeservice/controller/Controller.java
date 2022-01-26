package pro.sky.java.course2.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.DepartmentService;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
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

    @GetMapping("/employee/add")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam long salary, @RequestParam int departmentId) {
        Employee result = employeeService.add(firstName, lastName,salary,departmentId);
        return result + "успешно создан";
    }

    @GetMapping("/employee/find")
    public String findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam long salary, @RequestParam int departmentId) {
        Employee result = employeeService.find(firstName, lastName,salary,departmentId);
        return result + "найден";

    }

    @GetMapping("/employee/remove")
    public String eraseEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam long salary, @RequestParam int departmentId) {
         employeeService.remove(firstName, lastName,salary,departmentId);
        return firstName +" "+ lastName + " удалён";
    }


    @GetMapping("/employee/size")
    public int getSize () {
        int result = departmentService.size();
        return result;
    }

   @GetMapping ("/department/min-salary")
   public Optional<Employee> printMinSalary (@RequestParam int departmentId) {
        Optional<Employee> result = departmentService.findMinSalary(departmentId);
        return result;
    }

    @GetMapping ("/department/max-salary")
   public Optional<Employee> printMaxSalary (@RequestParam int departmentId) {
        Optional<Employee> result = departmentService.findMaxSalary(departmentId);
        return result;
    }
    @GetMapping("/department/all")
    public Stream<Employee> printDepartment(@RequestParam int departmentId) {
        Stream<Employee> result = departmentService.printDepartment(departmentId);
        return result;
    }

    @GetMapping("/departments/all")
    public List<Employee> print() {
        return departmentService.printAllDepartments();
    }




}
