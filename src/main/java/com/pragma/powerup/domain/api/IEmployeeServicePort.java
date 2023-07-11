package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Employee;

import java.util.List;

public interface IEmployeeServicePort {
    void saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployee(Long id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);

}
