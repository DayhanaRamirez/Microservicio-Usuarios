package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IEmployeeServicePort;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Employee;
import com.pragma.powerup.domain.spi.IEmployeePersistencePort;

import java.util.List;

public class EmployeeUseCase implements IEmployeeServicePort {

    private final IEmployeePersistencePort employeePersistencePort;


    public EmployeeUseCase(IEmployeePersistencePort employeePersistencePort) {
        this.employeePersistencePort = employeePersistencePort;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employee.setIdRole(3l);
        employeePersistencePort.saveEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeePersistencePort.getAllEmployees();
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeePersistencePort.getEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employee.setIdRole(3l);
        employeePersistencePort.updateEmployee(employee);

    }

    @Override
    public void deleteEmployee(Long id) {
        employeePersistencePort.deleteEmployee(id);

    }
}
