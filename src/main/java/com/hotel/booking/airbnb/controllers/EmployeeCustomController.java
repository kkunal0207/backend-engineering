package com.hotel.booking.airbnb.controllers;


import com.hotel.booking.airbnb.dtos.EmployeeDto;
import com.hotel.booking.airbnb.services.EmployeeCustomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customEmployee")
public class EmployeeCustomController {

    private final EmployeeCustomService employeeCustomService;

    EmployeeCustomController(EmployeeCustomService employeeCustomService) {
        this.employeeCustomService = employeeCustomService;
    }

    @GetMapping("{id}")
    public EmployeeDto getEmployeeById(@PathVariable(name="id") Long id){
        return employeeCustomService.getById(id);
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployee(
        @RequestParam(required = false, name="inputAge") Integer age,
        @RequestParam(required = false) String name
    ){
        return employeeCustomService.getAll();
    }

    @PostMapping
    public EmployeeDto saveAnEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeCustomService.saveAnEmployee(employeeDto);
    }
}
