package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IEmployeeServicePort;
import com.pragma.powerup.domain.exception.ForbiddenUserException;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Employee;
import com.pragma.powerup.domain.spi.IEmployeePersistencePort;
import com.pragma.powerup.infrastructure.configuration.security.TokenUtils;

import java.util.List;

public class EmployeeUseCase implements IEmployeeServicePort {

    private final IEmployeePersistencePort employeePersistencePort;
    private final TokenUtils tokenUtils;


    public EmployeeUseCase(IEmployeePersistencePort employeePersistencePort, TokenUtils tokenUtils) {
        this.employeePersistencePort = employeePersistencePort;
        this.tokenUtils = tokenUtils;
    }

    @Override
    public void saveEmployee(Account employee, String token) {
        String email = tokenUtils.getUsernameFromToken(token);
        Account account = employeePersistencePort.getAccountByEmail(email);
        if(account.getIdRole() == 3 || account.getIdRole() == 4  ){
            throw  new ForbiddenUserException();
        }
        employee.setIdRole(3l);
        employeePersistencePort.saveEmployee(employee);
    }

    @Override
    public List<Account> getAllEmployees() {
        return employeePersistencePort.getAllEmployees();
    }

    @Override
    public Account getEmployee(Long id) {
        return employeePersistencePort.getEmployee(id);
    }

    @Override
    public void updateEmployee(Account employee) {
        employee.setIdRole(3l);
        employeePersistencePort.updateEmployee(employee);

    }

    @Override
    public void deleteEmployee(Long id) {
        employeePersistencePort.deleteEmployee(id);

    }
}
