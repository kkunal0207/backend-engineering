package com.hotel.booking.airbnb.controllers;


import com.hotel.booking.airbnb.dtos.EmployeeDto;
import com.hotel.booking.airbnb.services.EmployeeCustomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/customEmployee")
public class EmployeeCustomController {

    private final EmployeeCustomService employeeCustomService;

    EmployeeCustomController(EmployeeCustomService employeeCustomService) {
        this.employeeCustomService = employeeCustomService;
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name="id") Long id) throws Exception {
//        return employeeCustomService.getById(id);
        Optional<EmployeeDto> employeeDto = employeeCustomService.getById(id);

        return employeeDto
            .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
            .orElseThrow(() -> new NoSuchElementException("Employee not found"));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchEmployeeException(NoSuchElementException noSuchElementException){
        return new ResponseEntity<>("No Such Employee Found", HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(
        @RequestParam(required = false, name="inputAge") Integer age,
        @RequestParam(required = false) String name
    ){
        return ResponseEntity.ok(employeeCustomService.getAll());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveAnEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.ok( employeeCustomService.saveAnEmployee(employeeDto));
    }

    @PutMapping("{employeeId}")
    public EmployeeDto updateAnEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long employeeId){
        return employeeCustomService.updateEmployee(employeeDto,employeeId);
    }

    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId){
        employeeCustomService.deleteById(employeeId);
    }
}
