package pro.sky.java.course2.employeeservice.service;

import pro.sky.java.course2.employeeservice.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface EmployeeService {

     Employee add(String firstName, String lastName, long salary, int departmentId);


     Employee remove(String firstName, String lastName, long salary, int departmentId);

     Employee find(String firstName, String lastName, long salary, int departmentId);

     Optional<Employee> findMinSalary (int departmentId);

     Optional<Employee> findMaxSalary (int departmentId);

     Stream<Employee> printDepartment(int departmentId);

     int size();

     List<Employee> printAllDepartments();










}
