package com.springboot.week2.controller;

import com.springboot.week2.dto.EmployeeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

    @GetMapping("/getsecret")
    public String getSecrets(){
        return "secret is: ah6272@^#%";
    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDto(employeeId, "Kunal","kunal@gmail.com", LocalDate.of(1999,8,21),true);
    }

    @GetMapping("/employees")
    public String getAge(@RequestParam(required = false) String age,
                         @RequestParam(required = true) String name){
        return "age is: "+age + "name is: "+name;
    }
}
