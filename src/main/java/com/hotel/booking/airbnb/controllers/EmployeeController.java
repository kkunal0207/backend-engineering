package com.hotel.booking.airbnb.controllers;

import com.hotel.booking.airbnb.dtos.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Random;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    @GetMapping(path = "/getsecrets")
//    public String getSecretMessage() {
//        return "my secret: 16236@^!%%";
//    }

//    @GetMapping(path = "/employee/{employeeId}")
//    public EmployeeDto getEmployeeDetails(@PathVariable Long employeeId) {
//        return new EmployeeDto(employeeId, "Kunal", "Kunal@gmail.com",26, LocalDate.now(),true);
//
//    }
//
//    @GetMapping(path="/employee")
//    public String getAllEmployees(
//        @RequestParam(required = false) int age,
//        @RequestParam(required = false) String name
//    ){
//        return "your age is: "+age +" " + name;
//    }

    @GetMapping(path = "{id}")
    public EmployeeDto getEmployeeDetails(@PathVariable(name = "id") Long employeeId) {
        return new EmployeeDto(employeeId, "Kunal", "Kunal@gmail.com",26, LocalDate.now(),true);

    }

    @GetMapping
    public String getAllEmployees(
        @RequestParam(required = false, name = "inputAge") Integer age,
        @RequestParam(required = false) String name
    ){
        String ageStr = (age == null) ? "null" : age.toString();
        String nameStr = (name == null) ? "" : name;
        return "your age is: " + ageStr + " " + nameStr;
    }
//
//    @PostMapping
//    public String saveEmployeeData(){
//        return "Post Mapping";
//    }

    @PostMapping
    public EmployeeDto saveEmployeeDetails(@RequestBody EmployeeDto employeeDetails){
        employeeDetails.setEmployeeId(111L);
        return employeeDetails;
    }

    @PutMapping
    public String updateEmployeeData(){
        return "Put Mapping";
    }

}
