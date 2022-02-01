package pro.sky.java.course2.employeeservice.service;

import pro.sky.java.course2.employeeservice.model.Employee;

import java.util.Collection;
import java.util.List;

public interface DepartmentService {
    Employee findMinSalary (Integer department);

    Employee findMaxSalary (Integer department);

    Collection<Employee> printDepartment(Integer department);
}
