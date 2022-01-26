package pro.sky.java.course2.employeeservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.EmployeeExistsException;
import pro.sky.java.course2.employeeservice.EmployeeNotFoundException;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.model.EmployeeList;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeList employeeList;

    public EmployeeServiceImpl(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public Employee add(String firstName, String lastName, long salary, int departmentId) {
        Employee newEmployee = new Employee(firstName, lastName, salary, departmentId);
        if (employeeList.getEmployees().contains(newEmployee)) {
            throw new EmployeeExistsException();
        }
        employeeList.getEmployees().add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName, long salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        employeeList.getEmployees().remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName, long salary, int departmentId) {
        for (Employee employee : employeeList.getEmployees()) {
            if (employee.equals(new Employee(firstName, lastName, salary,departmentId))) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }



}


