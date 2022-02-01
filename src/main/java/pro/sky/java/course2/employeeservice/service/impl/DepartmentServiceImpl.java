package pro.sky.java.course2.employeeservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.DepartmentService;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findMinSalary(Integer department) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public Employee findMaxSalary(Integer department) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    @Override
    public Collection<Employee> printDepartment(Integer department) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment()
                .equals(department)).collect(Collectors.toList());

    }
}
