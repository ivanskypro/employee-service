package pro.sky.java.course2.employeeservice.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeListConfiguration {

    @Bean
    public EmployeeList getEmployeeList() {
        return new EmployeeList();}
}
