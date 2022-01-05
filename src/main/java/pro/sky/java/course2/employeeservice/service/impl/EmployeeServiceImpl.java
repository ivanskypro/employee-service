package pro.sky.java.course2.employeeservice.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)){
            throw new EmployeeExistsException();
        }
        if (StringUtils.isNumeric(firstName) || StringUtils.isNumeric(lastName)) {
            throw new BadRequestException();
        }
        if (StringUtils.isAllLowerCase(firstName) || StringUtils.isAllLowerCase(lastName)){
            throw new BadRequestException();
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();}
            employees.remove(employee);
            return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (StringUtils.isNumeric(firstName) || StringUtils.isNumeric(lastName)) {
                throw new BadRequestException();
            }
            if (StringUtils.isAllLowerCase(firstName) || StringUtils.isAllLowerCase(lastName)){
                throw new BadRequestException();
            }
            if (employee.equals(new Employee(firstName, lastName))) {
                return employee;
            }

        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> print() {
        return employees;
    }

    @Override
    public int size() {
        return employees.size();
    }
}
