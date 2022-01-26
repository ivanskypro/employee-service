package pro.sky.java.course2.employeeservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.model.EmployeeList;
import pro.sky.java.course2.employeeservice.service.DepartmentService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeList employeeList;

    public DepartmentServiceImpl(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public Optional<Employee> findMinSalary(int departmentId) {
        return employeeList.getEmployees().stream()
                .filter(s -> s.getDepartment() == departmentId)
                .min(Comparator.comparingLong(s -> s.getSalary()));
    }

    @Override
    public Optional<Employee> findMaxSalary(int departmentId) {
        return employeeList.getEmployees().stream()
                .filter(s -> s.getDepartment() == departmentId)
                .max(Comparator.comparingLong(s -> s.getSalary()));
    }

    @Override
    public Stream<Employee> printDepartment(int departmentId) {
        return employeeList.getEmployees().stream().filter(s -> s.getDepartment() == departmentId);
    }

    @Override
    public List<Employee> printAllDepartments() {
        return employeeList.getEmployees();
    }

    @Override
    public int size() {
        return employeeList.getEmployees().size();
    }
}
