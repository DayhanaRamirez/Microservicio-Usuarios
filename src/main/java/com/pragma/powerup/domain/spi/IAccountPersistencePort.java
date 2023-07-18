package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Account;
import java.util.List;

public interface IAccountPersistencePort {

    void saveAccount(Account account);

    List<Account> getAllAccounts();

    Account getAccount(Long id);

    void updateAccount(Account account);

    void deleteAccount(Long id);

    Account getAccountByEmail(String email);

    Long getAccountIdRole(String email);

    Long[] getUserIdAndRole(String email);


}