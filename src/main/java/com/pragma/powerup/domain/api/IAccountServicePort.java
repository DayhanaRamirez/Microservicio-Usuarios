package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Account;
import java.util.List;

public interface IAccountServicePort {

    void saveAccount(Account account, String token);

    List<Account> getAllAccounts();

    Account getAccount(Long id);

    void updateAccount(Account account);

    void deleteAccount(Long id);

    Long getAccountIdRole(String token);
}