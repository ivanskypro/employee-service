package pro.sky.java.course2.employeeservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Сотрудник не найден";

    public EmployeeNotFoundException (){
        super(DEFAULT_MESSAGE);

    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
    public EmployeeNotFoundException (String message, Throwable cause) {
        super(message,cause);
    }

    public EmployeeNotFoundException(Throwable cause) {
        super(cause);
    }
}
