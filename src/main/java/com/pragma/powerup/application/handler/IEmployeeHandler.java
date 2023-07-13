package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.EmployeeRequestDto;
import com.pragma.powerup.application.dto.request.EmployeeRequestUpdateDto;
import com.pragma.powerup.application.dto.response.EmployeeResponseDto;

import java.util.List;

public interface IEmployeeHandler {

    void saveEmployee(EmployeeRequestDto employeeRequestDto, String token);

    List<EmployeeResponseDto> getAllEmployees();

    EmployeeResponseDto getEmployee(Long id);

    void updateEmployee(EmployeeRequestUpdateDto employeeRequestUpdateDto);

    void deleteEmployee(Long id);

}
