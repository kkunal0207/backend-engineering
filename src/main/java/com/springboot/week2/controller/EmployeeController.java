package com.springboot.week2.controller;

import com.springboot.week2.EmployeeRepository;
import com.springboot.week2.dto.EmployeeDto;
import com.springboot.week2.entity.EmployeeEntity;
import com.springboot.week2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDto> getById(@PathVariable Integer id){
        Optional<EmployeeDto> dto = employeeService.findById(id);
        if(dto.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto.get());
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> findAllEmployee(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody @Valid EmployeeDto inputEmployee){
        return new ResponseEntity<>(employeeService.saveAnEmployee(inputEmployee), HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateAnEmployee(@RequestBody EmployeeDto inputEmployee,
                                        @PathVariable Integer employeeId){
        return new ResponseEntity<>(employeeService.updateAnEmployee(inputEmployee,employeeId),HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteAnEmployeeById(@PathVariable Integer employeeId){
        employeeService.deleteAnEmployeeById(employeeId);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDto partiallyUpdateAnEmployee(@PathVariable Integer employeeId, @RequestBody Map<String, Object> updates){
        return employeeService.partaillyUpdateAnEmployee(employeeId, updates);
    }

}
