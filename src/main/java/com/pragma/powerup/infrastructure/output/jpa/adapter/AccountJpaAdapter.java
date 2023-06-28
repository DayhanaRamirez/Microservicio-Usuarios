package com.pragma.powerup.infrastructure.output.jpa.adapter;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IAccountPersistencePort;
import com.pragma.powerup.infrastructure.exception.AccountAlreadyExistsException;
import com.pragma.powerup.infrastructure.exception.AccountNotFoundException;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.output.jpa.entity.AccountEntity;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IAccountEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccountJpaAdapter implements IAccountPersistencePort {

    private final IAccountRepository accountRepository;
    private final IAccountEntityMapper accountEntityMapper;

    @Override
    public void saveAccount(Account account) {
        if(accountRepository.findById(account.getId()).isPresent()){
            throw new AccountAlreadyExistsException();
        }
        //account.setPassword(springCrearHash(account.getPassword()));
        account.setIdRole(2L);
        accountRepository.save(accountEntityMapper.accountToEntity(account));
    }

    @Override
    public List<Account> getAllAccounts() {
       List<AccountEntity> accountEntityList = accountRepository.findAll();
       if(accountEntityList.isEmpty()){
           throw new NoDataFoundException();
       }
        return accountEntityMapper.entityToAccountList(accountEntityList);
    }

    @Override
    public Account getAccount(Long id) {
        return accountEntityMapper.entityToAccount(accountRepository.findById(id)
                .orElseThrow(AccountNotFoundException::new));
    }

    @Override
    public void updateAccount(Account account) {
        accountRepository.save(accountEntityMapper.accountToEntity(account));
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}