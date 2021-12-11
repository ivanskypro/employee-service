package pro.sky.java.course2.employeeservice.service;

import pro.sky.java.course2.employeeservice.model.Employee;

public interface EmployeeService {

     Employee add(String firstName, String lastName);

     Employee add(Employee employee);

     Employee remove(String firstName, String lastName);

     Employee remove (Employee employee);

     Employee find(String firstName, String lastName);








}
