package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IAccountServicePort;
import com.pragma.powerup.domain.api.IGetToken;
import com.pragma.powerup.domain.exception.ForbiddenUserException;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IAccountPersistencePort;
import com.pragma.powerup.infrastructure.configuration.security.TokenUtils;

import java.util.List;

public class AccountUseCase implements IAccountServicePort {

    private final IAccountPersistencePort accountPersistencePort;

    private final IGetToken getToken;

    public AccountUseCase(IAccountPersistencePort accountPersistencePort, IGetToken getToken) {
        this.accountPersistencePort = accountPersistencePort;
        this.getToken = getToken;
    }

    @Override
    public void saveAccount(Account newAccount, String token) {
        String email = getToken.getUsernameFromToken(token);
        Account account = accountPersistencePort.getAccountByEmail(email);
        if(account.getIdRole() != 1){
            throw  new ForbiddenUserException();
        }
        newAccount.setIdRole(2L);
        accountPersistencePort.saveAccount(newAccount);
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
        account.setIdRole(2L);
        accountPersistencePort.updateAccount(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountPersistencePort.deleteAccount(id);
    }

    @Override
    public Long getAccountIdRole(String token) {
        String email = getToken.getUsernameFromToken(token);
        return accountPersistencePort.getAccountIdRole(email);
    }

    @Override
    public Long[] getUserIdAndRole(String token) {
        String email = getToken.getUsernameFromToken(token);
        return accountPersistencePort.getUserIdAndRole(email);
    }
}