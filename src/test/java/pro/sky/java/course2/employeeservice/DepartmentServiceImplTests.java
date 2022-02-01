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
import pro.sky.java.course2.employeeservice.service.impl.EmployeeNotFoundException;

import java.util.List;

    @ExtendWith(MockitoExtension.class)
    public class DepartmentServiceImplTests {

        String FIRST_NAME_1 = "Василий";
        String LAST_NAME_1 = "Киселев";
        long SALARY_1 = 25000;
        Integer DEPARTMENT_1 = 1;

        private Employee EXPECTED_EMPLOYEE_1 = new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_1);

        String FIRST_NAME_2 = "Виталий";
        String LAST_NAME_2 = "Круглов";
        long SALARY_2 = 25600;
        Integer DEPARTMENT_2 = 1;

        private Employee EXPECTED_EMPLOYEE_2 = new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_2);

        @Mock
        private EmployeeService employeeService;

        @InjectMocks
        private DepartmentServiceImpl out;

        @BeforeEach
        public void setEmployees() {
            Mockito.when(employeeService.getAllEmployees()).thenReturn(List.of(
                    new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_1),
                    new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_2)));
        }

        @Test
        public void willMinSalaryWorkIfDepartmentsAreEmpty(){
            Assertions.assertThrows(EmployeeNotFoundException.class, () ->out.findMinSalary(4));
        }

        @Test
            public void willMaxSalaryWorkIfDepartmentsAreEmpty(){
            Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.findMaxSalary(4));
        }

        @Test
        public void willMinSalaryWork(){
            Assertions.assertEquals(out.findMinSalary(1),new Employee(FIRST_NAME_1,LAST_NAME_1,SALARY_1,DEPARTMENT_1));
        }

        @Test
        public void willMaxSalaryWork(){
            Assertions.assertEquals(out.findMaxSalary(1),new Employee(FIRST_NAME_1,LAST_NAME_1,SALARY_1,DEPARTMENT_1));
        }

        @Test
        public void willPrintDepartmentWork(){
            Assertions.assertEquals(out.printDepartment(1),
                    List.of(new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_1),
                    new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_2)));
        }
    }


