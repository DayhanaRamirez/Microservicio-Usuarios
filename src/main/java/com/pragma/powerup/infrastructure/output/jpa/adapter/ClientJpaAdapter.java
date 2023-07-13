package com.pragma.powerup.infrastructure.output.jpa.adapter;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Client;
import com.pragma.powerup.domain.spi.IClientPersistencePort;
import com.pragma.powerup.infrastructure.exception.AccountNotFoundException;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import com.pragma.powerup.infrastructure.output.jpa.entity.AccountEntity;
import com.pragma.powerup.infrastructure.output.jpa.entity.ClientEntity;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IClientEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IRoleEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.IClientRepository;
import com.pragma.powerup.infrastructure.output.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientJpaAdapter implements IClientPersistencePort {

    private final IClientRepository clientRepository;
    private final IClientEntityMapper clientEntityMapper;
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;


    @Override
    public void saveClient(Account client) {
        AccountEntity clientEntity = clientEntityMapper.clientToEntity(client);
        clientEntity.setRoleEntity(roleRepository.getReferenceById(client.getIdRole()));
        clientRepository.save(clientEntity);
    }

    @Override
    public List<Account> getAllClients() {
        List<AccountEntity> clientEntityList = clientRepository.findAll();
        if(clientEntityList.isEmpty()){
            throw new NoDataFoundException();
        }

        return clientEntityMapper.entitiesToClientList(clientEntityList);
    }

    @Override
    public Account getClient(Long id) {
        AccountEntity clientEntity = clientRepository.getReferenceById(id);
        Account client = clientEntityMapper.entityToClient(clientEntity);
        client.setIdRole(roleEntityMapper.entityToRole(clientEntity.getRoleEntity()).getId());
        return client;
    }

    @Override
    public void updateClient(Account client) {
        saveClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Account getAccountByEmail(String email) {
        AccountEntity accountEntity = clientRepository.findFirstByEmail(email);
        if(accountEntity == null){
            throw  new AccountNotFoundException();
        }

        Account account = clientEntityMapper.entityToClient(accountEntity);
        account.setIdRole(roleEntityMapper.entityToRole(accountEntity.getRoleEntity()).getId());
        return account;
    }
}
