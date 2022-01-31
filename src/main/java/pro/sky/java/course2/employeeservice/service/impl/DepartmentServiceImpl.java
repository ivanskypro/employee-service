package pro.sky.java.course2.employeeservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.DepartmentService;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;
    private final Employee employee;


    public DepartmentServiceImpl(EmployeeService employeeService, Employee employee) {
        this.employeeService = employeeService;
        this.employee = employee;
    }

    @Override
    public Optional<Employee> findMinSalary(int departmentId) {
        return employeeService.printAllDepartments().stream()
                    .filter(s -> s.getDepartment() == departmentId)
                    .min(Comparator.comparingLong(s -> s.getSalary()));

    }

    @Override
    public Optional<Employee> findMaxSalary(int departmentId) {
        return employeeService.printAllDepartments().stream()
                .filter(s -> s.getDepartment() == departmentId)
                .max(Comparator.comparingLong(s -> s.getSalary()));
    }

    @Override
    public Stream<Employee> printDepartment(int departmentId) {
        return employeeService.printAllDepartments().stream().filter(s -> s.getDepartment() == departmentId);
    }

    @Override
    public int size() {
        return employeeService.printAllDepartments().size();
    }
}
