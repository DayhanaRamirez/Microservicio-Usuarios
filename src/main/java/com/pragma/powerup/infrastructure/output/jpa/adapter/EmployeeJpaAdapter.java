package com.pragma.powerup.infrastructure.output.jpa.adapter;

import com.pragma.powerup.domain.model.Employee;
import com.pragma.powerup.domain.spi.IEmployeePersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.output.jpa.entity.EmployeeEntity;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IEmployeeEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IRoleEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.IEmployeeRepository;
import com.pragma.powerup.infrastructure.output.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeJpaAdapter implements IEmployeePersistencePort {

    private final IEmployeeRepository employeeRepository;
    private final IEmployeeEntityMapper employeeEntityMapper;
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Override
    public void saveEmployee(Employee employee) {
        EmployeeEntity employeeEntity = employeeEntityMapper.employeeToEntity(employee);
        employeeEntity.setRoleEntity(roleRepository.getReferenceById(employee.getIdRole()));
        employeeRepository.save(employeeEntity);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        if(employeeEntityList.isEmpty()){
            throw new NoDataFoundException();
        }

        return employeeEntityMapper.entitiesToEmployeeList(employeeEntityList);
    }

    @Override
    public Employee getEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getReferenceById(id);
        Employee employee = employeeEntityMapper.entityToEmployee(employeeEntity);
        employee.setIdRole(roleEntityMapper.entityToRole(employeeEntity.getRoleEntity()).getId());
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        saveEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
