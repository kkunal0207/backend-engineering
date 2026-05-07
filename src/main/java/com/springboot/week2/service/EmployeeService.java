package com.springboot.week2.service;

import com.springboot.week2.EmployeeRepository;
import com.springboot.week2.configs.MapperConfig;
import com.springboot.week2.dto.EmployeeDto;
import com.springboot.week2.entity.EmployeeEntity;
import com.springboot.week2.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;
//    ModelMapper mapper = new ModelMapper();

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper){
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public Optional<EmployeeDto> findById(Integer id) {
        return employeeRepository.findById(id).map(employeeEntity -> mapper.map(employeeEntity,EmployeeDto.class));

    }

    public List<EmployeeDto> findAll(){
        return employeeRepository.findAll()
                .stream()
                .map( employee-> mapper.map(employee,EmployeeDto.class)).toList();
    }

    public EmployeeDto saveAnEmployee(EmployeeDto inputEmployee){

        return mapper.map(employeeRepository.save(mapper.map(inputEmployee,EmployeeEntity.class)), EmployeeDto.class);
    }

    public EmployeeDto updateAnEmployee(EmployeeDto inputEmployee, Integer employeeId){
        Boolean exists = isEmployeeExistsByEmployeeId(employeeId);
        if(!exists) throw new ResourceNotFoundException("Employee Not Found By Id: "+employeeId);
        EmployeeEntity entity = mapper.map(inputEmployee,EmployeeEntity.class);
        entity.setId(employeeId);
        return mapper.map(employeeRepository.save(entity),EmployeeDto.class);

    }

    public Boolean isEmployeeExistsByEmployeeId(Integer employeeId){
        return employeeRepository.existsById(employeeId);
    }

    public void deleteAnEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public EmployeeDto partaillyUpdateAnEmployee(Integer employeeId, Map<String, Object> updates) {
        EmployeeEntity entity = employeeRepository.findById(employeeId).orElseThrow(null);
        updates.forEach((key,value) ->{
            Field field = ReflectionUtils.findField(EmployeeEntity.class,key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,entity,value);
        });

        return mapper.map(employeeRepository.save(entity),EmployeeDto.class);

    }
}
