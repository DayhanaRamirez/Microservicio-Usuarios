package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Employee;

import java.util.List;

public interface IEmployeeServicePort {
    void saveEmployee(Account account, String token);

    List<Account> getAllEmployees();

    Account getEmployee(Long id);

    void updateEmployee(Account account);

    void deleteEmployee(Long id);

}
