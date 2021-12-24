package pro.sky.java.course2.employeeservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.EmployeeService;


import java.util.*;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();


    @Override
    public Employee add(String firstName, String lastName, long salary, int departmentId) {
        Employee newEmployee = new Employee(firstName, lastName, salary, departmentId);
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName, long salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, long salary, int departmentId) {
        for (Employee employee : employees) {
            if (employee.equals(new Employee(firstName, lastName, salary,departmentId))) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Optional<Employee> findMinSalary(int departmentId) {
       return employees.stream()
                .filter(s -> s.getDepartment() == departmentId)
                .min(Comparator.comparingLong(s -> s.getSalary()));
    }

    @Override
    public Optional<Employee> findMaxSalary(int departmentId) {
        return employees.stream()
                .filter(s -> s.getDepartment() == departmentId)
                .max(Comparator.comparingLong(s -> s.getSalary()));
    }

    @Override
    public Stream<Employee> printDepartment(int departmentId) {
        return employees.stream().filter(s -> s.getDepartment() == departmentId);
    }

    @Override
    public List <Employee> printAllDepartments() {
        return employees;
    }

    @Override
    public int size() {
        return employees.size();
    }

}


