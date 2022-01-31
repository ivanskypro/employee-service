package pro.sky.java.course2.employeeservice.service;

import pro.sky.java.course2.employeeservice.model.Employee;

import java.util.List;


public interface EmployeeService {

     Employee add(String firstName, String lastName, long salary, int departmentId);


     Employee remove(String firstName, String lastName, long salary, int departmentId);

     Employee find(String firstName, String lastName, long salary, int departmentId);

     List<Employee> printAllDepartments();










}
