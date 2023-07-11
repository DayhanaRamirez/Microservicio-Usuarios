package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Employee;

import java.util.List;

public interface IEmployeePersistencePort {
    void saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployee(Long id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}
