package com.pragma.powerup.infrastructure.output.jpa.adapter;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IAccountPersistencePort;
import com.pragma.powerup.infrastructure.exception.AccountNotFoundException;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.output.jpa.entity.AccountEntity;
import com.pragma.powerup.infrastructure.output.jpa.entity.RoleEntity;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IAccountEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.IAccountRepository;
import com.pragma.powerup.infrastructure.output.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountJpaAdapter implements IAccountPersistencePort {

    private final IAccountRepository accountRepository;
    private final IRoleRepository roleRepository;
    private final IAccountEntityMapper accountEntityMapper;

    @Override
    public void saveAccount(Account account) {
        AccountEntity entity = accountEntityMapper.accountToEntity(account);
        entity.setRoleEntity(roleRepository.getReferenceById(account.getIdRole()));
        accountRepository.save(entity);
    }

    @Override
    public List<Account> getAllAccounts() {
       List<AccountEntity> accountEntityList = accountRepository.findAll();
       if(accountEntityList.isEmpty()){
           throw new NoDataFoundException();
       }
        return accountEntityMapper.entitiesToAccountList(accountEntityList);
    }

    @Override
    public Account getAccount(Long id) {
        return accountEntityMapper.entityToAccount(accountRepository.findById(id)
                .orElseThrow(AccountNotFoundException::new));
    }

    @Override
    public void updateAccount(Account account) {
        saveAccount(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}