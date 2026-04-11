package com.springboot.week2.service;

import com.springboot.week2.EmployeeRepository;
import com.springboot.week2.configs.MapperConfig;
import com.springboot.week2.dto.EmployeeDto;
import com.springboot.week2.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
//    ModelMapper mapper = new ModelMapper();

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper){
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeDto findById(Integer id) {
//        ModelMapper mapper = new ModelMapper();
        return mapper.map(employeeRepository.findById(id),EmployeeDto.class);
    }

    public List<EmployeeDto> findAll(){
        return employeeRepository.findAll()
                .stream()
                .map( employee-> mapper.map(employee,EmployeeDto.class)).toList();
    }

    public EmployeeDto saveAnEmployee(EmployeeDto inputEmployee){

        return mapper.map(employeeRepository.save(mapper.map(inputEmployee,EmployeeEntity.class)), EmployeeDto.class);
    }
}
