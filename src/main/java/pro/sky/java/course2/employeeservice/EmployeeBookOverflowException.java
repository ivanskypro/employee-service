package pro.sky.java.course2.employeeservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeBookOverflowException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Массив сотрудников полон";

    public EmployeeBookOverflowException(String message){
        super(message);
    }
    public EmployeeBookOverflowException(){
        this(DEFAULT_MESSAGE);
    }
}
