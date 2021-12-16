package pro.sky.java.course2.employeeservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.remove(employee);
        return employee;}


    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public List<Employee> print() {
        for (int i = 0; i < employees.size() ; i++) {
        }
        return employees;
    }

    @Override
    public int size() {
       int size = employees.size();
        return size;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (Objects.equals(employees.get(i), new Employee(firstName, lastName))) {
                return employees.get(i);
            } }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee replace(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employees.get(i) != null) {
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                return employee;
            }
        }
        throw new EmployeeExistsException();
    }

    public int size(Employee employee) {
        return employees.size();
    }
}











