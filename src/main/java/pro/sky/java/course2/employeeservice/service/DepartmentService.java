package pro.sky.java.course2.employeeservice.service;

import pro.sky.java.course2.employeeservice.model.Employee;

import java.util.Optional;
import java.util.stream.Stream;

public interface DepartmentService {

    Optional<Employee> findMinSalary (int departmentId);

    Optional<Employee> findMaxSalary (int departmentId);

    Stream<Employee> printDepartment(int departmentId);

    int size();

}
