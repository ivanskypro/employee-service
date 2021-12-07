package pro.sky.java.course2.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в сервис по работе с работниками!";
    }
}
