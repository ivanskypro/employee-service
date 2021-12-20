package pro.sky.java.course2.employeeservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, String> employees = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        employees.put(firstName,lastName);
        return newEmployee;
    }

    @Override
    public boolean remove(String firstName, String lastName) {
            boolean deletedEmployee = employees.remove(firstName,lastName);
            return deletedEmployee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
         if (!employees.containsKey(firstName) || !employees.containsValue(lastName)){
             throw new EmployeeNotFoundException();}
                 employees.get(employee);
                return employee;}



    @Override
    public Map<String, String> getEmployees() {
    for (Map.Entry <String,String> employee: employees.entrySet()){
        String employees = employee.getKey() + employee.getValue();}
        return employees;
    }

    @Override
    public int size() {
        return employees.size();
    }
}
