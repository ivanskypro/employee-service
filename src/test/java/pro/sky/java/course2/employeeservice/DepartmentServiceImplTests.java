package pro.sky.java.course2.employeeservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.EmployeeService;
import pro.sky.java.course2.employeeservice.service.impl.DepartmentServiceImpl;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTests {
    String FIRST_NAME_1 = "Василий";
    String LAST_NAME_1 = "Киселев";
    long SALARY_1 = 0;
    int DEPARTMENT_ID_1 = 1;

    private Employee EXPECTED_EMPLOYEE_1 = new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_ID_1);

    String FIRST_NAME_2 = "Витайлий";
    String LAST_NAME_2 = "Круглов";
    long SALARY_2 = 0;
    int DEPARTMENT_ID_2 = 1;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    public void setEmployees() {
        Mockito.when(employeeService.printAllDepartments()).thenReturn(List.of(
                new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_ID_1),
                new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_ID_2)));
    }

    @Test
    public void willFindMinSalaryMethodWorkIfSalaryIsEmpty() {
        Optional<Employee> expected = Optional.of(new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_ID_1));
        Assertions.assertEquals(out.findMinSalary(1), expected);
    }

    @Test
    public void willFindMaxSalaryMethodWorkIfSalaryIsEmpty() {
        Optional<Employee> expected = Optional.of(new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_ID_2));
        Assertions.assertEquals(out.findMaxSalary(1), expected);
    }

    @Test
    public void willGetAllDepartmentsWork() {
        Stream<Employee> actual = out.printDepartment(1);
        Optional<Employee> expected = Optional.of(new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_ID_2));
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void willGetAllDepartmentsMethodWillWorkIfListIsEmpty() {
        Stream<Employee> actual = out.printDepartment(1);
        Assertions.assertEquals(actual, Collections.emptyList());
    }
}