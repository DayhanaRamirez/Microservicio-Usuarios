package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.EmployeeRequestDto;
import com.pragma.powerup.application.dto.request.EmployeeRequestUpdateDto;
import com.pragma.powerup.application.dto.response.EmployeeResponseDto;
import com.pragma.powerup.application.handler.IEmployeeHandler;
import com.pragma.powerup.application.mapper.IObjectRequestMapper;
import com.pragma.powerup.application.mapper.IObjectResponseMapper;
import com.pragma.powerup.domain.api.IEmployeeServicePort;
import com.pragma.powerup.domain.model.Employee;
import com.pragma.powerup.domain.spi.IEncryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeHandler implements IEmployeeHandler {

    private final IEmployeeServicePort employeeServicePort;
    private final IObjectRequestMapper objectRequestMapper;
    private final IObjectResponseMapper objectResponseMapper;
    private final IEncryptService encryptService;

    @Override
    public void saveEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = objectRequestMapper.employeeDtoToEmployee(employeeRequestDto);
        employee.setPassword(encryptService.encryptPassword(employeeRequestDto.getPassword()));
        employeeServicePort.saveEmployee(employee);

    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        return objectResponseMapper.employeeToEmployeeDtoList(employeeServicePort.getAllEmployees());
    }

    @Override
    public EmployeeResponseDto getEmployee(Long id) {
        return objectResponseMapper.employeeToEmployeeDtp(employeeServicePort.getEmployee(id));
    }

    @Override
    public void updateEmployee(EmployeeRequestUpdateDto employeeRequestUpdateDto) {
        Employee employee = employeeServicePort.getEmployee(employeeRequestUpdateDto.getId());
        employee.setName(employeeRequestUpdateDto.getName());
        employee.setLastName(employeeRequestUpdateDto.getLastName());
        employee.setDocument(employeeRequestUpdateDto.getDocument());
        employee.setCellphone(employeeRequestUpdateDto.getCellphone());
        employee.setEmail(employeeRequestUpdateDto.getEmail());
        employee.setPassword(encryptService.encryptPassword(employeeRequestUpdateDto.getPassword()));
        employee.setIdRestaurant(employeeRequestUpdateDto.getIdRestaurant());
        employeeServicePort.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeServicePort.deleteEmployee(id);
    }
}
