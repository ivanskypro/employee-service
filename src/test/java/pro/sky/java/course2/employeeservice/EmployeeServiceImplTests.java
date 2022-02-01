package pro.sky.java.course2.employeeservice;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pro.sky.java.course2.employeeservice.model.Employee;
import pro.sky.java.course2.employeeservice.service.impl.EmployeeServiceImpl;

public class EmployeeServiceImplTests {
    EmployeeServiceImpl out = new EmployeeServiceImpl();

    String FIRST_NAME_1 = "Василий";
    String LAST_NAME_1 = "Киселев";
    long SALARY_1 = 254000;
    Integer DEPARTMENT_ID_1 = 1;

    private Employee EXPECTED_EMPLOYEE_1 = new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_ID_1);

    String FIRST_NAME_2 = "Витайлий";
    String LAST_NAME_2 = "Круглов";
    long SALARY_2 = 20000;
    Integer DEPARTMENT_ID_2 = 2;

    private Employee EXPECTED_EMPLOYEE_2 = new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_ID_1);

    String EMPTY_FIRST_NAME = "";
    String EMPTY_LAST_NAME = "";
    long EMPTY_SALARY = 0;
    Integer EMPTY_DEPARTMENT = 0;

    private Employee EXPECTED_EMPLOYEE_3 = new Employee(EMPTY_FIRST_NAME, EMPTY_LAST_NAME, EMPTY_SALARY, EMPTY_DEPARTMENT);

    String FIRST_NAME_BY_NUMS = "123";
    String LAST_NAME_BY_NUMS = "123";


    private Employee EXPECTED_EMPLOYEE_4 = new Employee(FIRST_NAME_BY_NUMS, LAST_NAME_BY_NUMS, SALARY_1, DEPARTMENT_ID_1);

    @Test
    public void willEmployeeBeAdded(){
        Assertions.assertEquals(EXPECTED_EMPLOYEE_1,out.add(FIRST_NAME_1,LAST_NAME_1,SALARY_1,DEPARTMENT_ID_1));
    }

    @Test
    public void willEmployeeBeAddedIfValueIsEmpty(){
        Assertions.assertEquals(EXPECTED_EMPLOYEE_3, out.add(EMPTY_FIRST_NAME,EMPTY_LAST_NAME,EMPTY_SALARY,EMPTY_DEPARTMENT));
    }

    @Test
    public void willEmployeeBeAddedIfNamesAreWrongType (){
        Assertions.assertEquals(EXPECTED_EMPLOYEE_4, out.add(FIRST_NAME_BY_NUMS,LAST_NAME_BY_NUMS,SALARY_1,DEPARTMENT_ID_1));
    }

    @Test
    public void throwingIllegalArgumentException (){
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.add(EMPTY_FIRST_NAME, EMPTY_LAST_NAME, EMPTY_SALARY, EMPTY_DEPARTMENT));
    }

    @Test
    public void willEmployeeBeDeleted (){
        out.add(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_ID_1);
        Assertions.assertEquals(EXPECTED_EMPLOYEE_1,out.remove(FIRST_NAME_1,LAST_NAME_1,SALARY_1,DEPARTMENT_ID_1));
    }
}
