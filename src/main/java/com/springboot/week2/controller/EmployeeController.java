package com.springboot.week2.controller;

import com.springboot.week2.EmployeeRepository;
import com.springboot.week2.dto.EmployeeDto;
import com.springboot.week2.entity.EmployeeEntity;
import com.springboot.week2.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

//    private final EmployeeRepository employeeRepository;
//
//    public  EmployeeController(EmployeeRepository employeeRepository){
//        this.employeeRepository = employeeRepository;
//    }

//    @GetMapping("getbyid/{id}")
//    public String getEmployeeById(@PathVariable Integer id){
//        return "id: "+id;
//    }

//    @GetMapping("{id}")
//    public EmployeeEntity getById(@PathVariable Integer id){
//        return employeeRepository.findById(id).orElseThrow(null);
//    }
//
//    @GetMapping("/all")
//    public List<EmployeeEntity> findAllEmployee(){
//        return employeeRepository.findAll();
//    }
//
//    @PostMapping
//    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
//        return employeeRepository.save(inputEmployee);
//    }

    @GetMapping("{id}")
    public EmployeeDto getById(@PathVariable Integer id){
        return employeeService.findById(id);
    }

    @GetMapping("/all")
    public List<EmployeeDto> findAllEmployee(){
        return employeeService.findAll();
    }

    @PostMapping
    public EmployeeDto createNewEmployee(@RequestBody EmployeeDto inputEmployee){
        return employeeService.saveAnEmployee(inputEmployee);
    }



}
