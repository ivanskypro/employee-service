package pro.sky.java.course2.employeeservice.service;

import pro.sky.java.course2.employeeservice.model.Employee;

import java.util.Map;

public interface EmployeeService {

     Employee add(String firstName, String lastName);


     boolean remove(String firstName, String lastName);

     Map<String, String> getEmployees();

     int size();

     Employee find(String firstName, String lastName);










}
