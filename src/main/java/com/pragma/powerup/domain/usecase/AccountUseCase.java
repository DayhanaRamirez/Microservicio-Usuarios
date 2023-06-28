package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IAccountServicePort;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IAccountPersistencePort;

import java.util.List;

public class AccountUseCase implements IAccountServicePort {

    private final IAccountPersistencePort accountPersistencePort;

    public AccountUseCase(IAccountPersistencePort accountPersistencePort) {
        this.accountPersistencePort = accountPersistencePort;
    }

    @Override
    public void saveAccount(Account account) {
        accountPersistencePort.saveAccount(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountPersistencePort.getAllAccounts();
    }

    @Override
    public Account getAccount(Long id) {
        return accountPersistencePort.getAccount(id);
    }

    @Override
    public void updateAccount(Account account) {
        accountPersistencePort.updateAccount(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountPersistencePort.deleteAccount(id);
    }
}