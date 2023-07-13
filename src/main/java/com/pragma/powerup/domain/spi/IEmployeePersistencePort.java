package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Employee;

import java.util.List;

public interface IEmployeePersistencePort {
    void saveEmployee(Account account);

    List<Account> getAllEmployees();

    Account getEmployee(Long id);

    void updateEmployee(Account account);

    void deleteEmployee(Long id);

    Account getAccountByEmail(String email);
}
