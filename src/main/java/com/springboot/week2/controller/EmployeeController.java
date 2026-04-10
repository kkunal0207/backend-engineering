package com.springboot.week2.controller;

import com.springboot.week2.EmployeeRepository;
import com.springboot.week2.dto.EmployeeDto;
import com.springboot.week2.entity.EmployeeEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public  EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

//    @GetMapping("getbyid/{id}")
//    public String getEmployeeById(@PathVariable Integer id){
//        return "id: "+id;
//    }

    @GetMapping("{id}")
    public EmployeeEntity getById(@PathVariable Integer id){
        return employeeRepository.findById(id).orElseThrow(null);
    }

    @GetMapping("/all")
    public List<EmployeeEntity> findAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);

    }


}
