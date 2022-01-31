package pro.sky.java.course2.employeeservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.EmployeeExistsException;
import pro.sky.java.course2.employeeservice.EmployeeNotFoundException;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public static boolean isNumeric(String name) {
        for (char c : name.toCharArray())
            if (Character.isDigit(c)){
                return true;}
        return false;
    }


    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName, long salary, int departmentId) {
        Employee newEmployee = new Employee(firstName, lastName, salary, departmentId);
        if (employeeList.contains(newEmployee)) {
            throw new EmployeeExistsException();
        }
        if (firstName.isEmpty() || lastName.isEmpty() || salary <=0 || departmentId <=0){
            throw new IllegalArgumentException();
        }
        if (isNumeric(firstName) == true || isNumeric(lastName)){
            throw new IllegalArgumentException();
        }
        employeeList.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName, long salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
            if (!employeeList.contains(employee)) {
                throw new IllegalArgumentException();
            }
        employeeList.remove(employee);
        return employee;
    }
    @Override
    public Employee find(String firstName, String lastName, long salary, int departmentId) {
        for (Employee employee : employeeList) {
            if (employee.equals(new Employee(firstName, lastName, salary,departmentId))) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> printAllDepartments() {
        return employeeList;
    }
}


