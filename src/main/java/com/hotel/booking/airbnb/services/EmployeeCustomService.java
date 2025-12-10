package com.hotel.booking.airbnb.services;

import com.hotel.booking.airbnb.configs.ModelMapperConfig;
import com.hotel.booking.airbnb.dtos.EmployeeDto;
import com.hotel.booking.airbnb.entities.EmployeeEntity;
import com.hotel.booking.airbnb.repositories.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeCustomService {

    private final IEmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    EmployeeCustomService(IEmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public EmployeeDto getById(Long id) {
        EmployeeEntity getEntityById = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(getEntityById, EmployeeDto.class);
    }

    public List<EmployeeDto> getAll() {
        List<EmployeeEntity> getAllEmployee = employeeRepository.findAll();

        return getAllEmployee.
            stream()
            .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class))
            .collect(Collectors.toList());
    }

    public EmployeeDto saveAnEmployee(EmployeeDto employeeDto) {
        EmployeeEntity toSaveAnEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        EmployeeEntity savedEntity = employeeRepository.save(toSaveAnEntity);

        return modelMapper.map(savedEntity,EmployeeDto.class);
    }
}
