package com.pragma.powerup.infrastructure.output.jpa.adapter;

import com.pragma.powerup.domain.model.Client;
import com.pragma.powerup.domain.spi.IClientPersistencePort;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
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
    public void saveClient(Client client) {
        ClientEntity clientEntity = clientEntityMapper.clientToEntity(client);
        clientEntity.setRoleEntity(roleRepository.getReferenceById(client.getIdRole()));
        clientRepository.save(clientEntity);
    }

    @Override
    public List<Client> getAllClients() {
        List<ClientEntity> clientEntityList = clientRepository.findAll();
        if(clientEntityList.isEmpty()){
            throw new NoDataFoundException();
        }

        return clientEntityMapper.entitiesToClientList(clientEntityList);
    }

    @Override
    public Client getClient(Long id) {
        ClientEntity clientEntity = clientRepository.getReferenceById(id);
        Client client = clientEntityMapper.entityToClient(clientEntity);
        client.setIdRole(roleEntityMapper.entityToRole(clientEntity.getRoleEntity()).getId());
        return client;
    }

    @Override
    public void updateClient(Client client) {
        saveClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
