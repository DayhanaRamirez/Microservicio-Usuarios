package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IAccountServicePort;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IAccountPersistencePort;
import com.pragma.powerup.domain.spi.IEncryptService;

import java.util.List;

public class AccountUseCase implements IAccountServicePort {

    private final IAccountPersistencePort accountPersistencePort;
    private final IEncryptService encryptServiceImpl;

    public AccountUseCase(IAccountPersistencePort accountPersistencePort, IEncryptService encryptService) {
        this.accountPersistencePort = accountPersistencePort;
        this.encryptServiceImpl = encryptService;
    }

    @Override
    public void saveAccount(Account account) {
        account.setPassword(encryptServiceImpl.encryptPassword(account.getPassword()));
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
        account.setPassword(encryptServiceImpl.encryptPassword(account.getPassword()));
        accountPersistencePort.updateAccount(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountPersistencePort.deleteAccount(id);
    }
}