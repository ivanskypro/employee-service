package pro.sky.java.course2.employeeservice.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName, long salary, Integer department) {
        Employee newEmployee = new Employee(firstName, lastName, salary,department);
        if (invalidInput(firstName, lastName))
            throw new BadRequestException();
        if (employees.contains(newEmployee))
            throw new EmployeeExistsException();
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName, long salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (invalidInput(firstName,lastName))
            throw new BadRequestException();
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();}
            employees.remove(employee);
            return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, long salary, Integer department) {
        for (Employee employee : employees) {
            if (invalidInput(firstName,lastName))
                throw new BadRequestException();
            if (employee.equals(new Employee(firstName, lastName, salary, department))) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public int size() {
        return employees.size();
    }

    private boolean invalidInput (String firstName, String lastName){
        return StringUtils.isAllLowerCase(firstName) || StringUtils.isAllLowerCase(lastName)
                || StringUtils.isNumeric(firstName) || StringUtils.isNumeric(lastName)
                || StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName);
    }
    }

