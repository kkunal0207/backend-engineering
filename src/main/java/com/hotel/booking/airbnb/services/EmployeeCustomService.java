package com.hotel.booking.airbnb.services;

import com.hotel.booking.airbnb.dtos.EmployeeDto;
import com.hotel.booking.airbnb.entities.EmployeeEntity;
import com.hotel.booking.airbnb.repositories.IEmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeCustomService {

    private final IEmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    EmployeeCustomService(IEmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<EmployeeDto> getById(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity,EmployeeDto.class));
//        EmployeeEntity getEntityById = employeeRepository.findById(id).orElse(null);
//        return modelMapper.map(getEntityById, EmployeeDto.class);
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

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId) {
        EmployeeEntity toUpdateEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
        EmployeeEntity updatedEntity = employeeRepository.save(toUpdateEntity);

        return modelMapper.map(updatedEntity,EmployeeDto.class);
    }

    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
