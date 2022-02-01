package pro.sky.java.course2.employeeservice.service;

import pro.sky.java.course2.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeService {

     Employee add(String firstName, String lastName, long salary, Integer department);


     Employee remove(String firstName, String lastName, long salary, Integer department);

     List<Employee> getAllEmployees();

     int size();

     Employee find(String firstName, String lastName, long salary, Integer department);










}
