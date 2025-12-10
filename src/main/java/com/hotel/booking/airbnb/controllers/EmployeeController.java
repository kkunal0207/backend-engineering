package com.hotel.booking.airbnb.controllers;

import com.hotel.booking.airbnb.dtos.EmployeeDto;
import com.hotel.booking.airbnb.entities.EmployeeEntity;
import com.hotel.booking.airbnb.repositories.IEmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

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

//    @GetMapping(path = "{id}")
//    public EmployeeDto getEmployeeDetails(@PathVariable(name = "id") Long employeeId) {
//        return new EmployeeDto(employeeId, "Kunal", "Kunal@gmail.com",26, LocalDate.now(),true);
//
//    }
//
//    @GetMapping
//    public String getAllEmployees(
//        @RequestParam(required = false, name = "inputAge") Integer age,
//        @RequestParam(required = false) String name
//    ){
//        String ageStr = (age == null) ? "null" : age.toString();
//        String nameStr = (name == null) ? "" : name;
//        return "your age is: " + ageStr + " " + nameStr;
//    }
//
//    @PostMapping
//    public String saveEmployeeData(){
//        return "Post Mapping";
//    }

    @GetMapping(path = "{id}")
    public EmployeeEntity getEmployeeDetails(@PathVariable(name = "id") Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);

    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(
        @RequestParam(required = false, name = "inputAge") Integer age,
        @RequestParam(required = false) String name
    ) {
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity saveEmployeeDetails(@RequestBody EmployeeEntity employeeDetails) {
        return employeeRepository.save(employeeDetails);
    }

    @PutMapping
    public String updateEmployeeData() {
        return "Put Mapping";
    }

//    @PostMapping
//    public EmployeeDto saveEmployeeDetails(@RequestBody EmployeeDto employeeDetails){
//        employeeDetails.setEmployeeId(111L);
//        return employeeDetails;
//    }
//
//    @PutMapping
//    public String updateEmployeeData(){
//        return "Put Mapping";
//    }

}
