package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IClientServicePort;
import com.pragma.powerup.domain.exception.ForbiddenUserException;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Client;
import com.pragma.powerup.domain.spi.IClientPersistencePort;
import com.pragma.powerup.infrastructure.configuration.security.TokenUtils;

import java.util.List;

public class ClientUseCase implements IClientServicePort {
    private final IClientPersistencePort clientPersistencePort;
    private final TokenUtils tokenUtils;

    public ClientUseCase(IClientPersistencePort clientPersistencePort, TokenUtils tokenUtils) {
        this.clientPersistencePort = clientPersistencePort;
        this.tokenUtils = tokenUtils;
    }

    @Override
    public void saveClient(Account client, String token) {
        client.setIdRole(4L);
        clientPersistencePort.saveClient(client);


    }

    @Override
    public List<Account> getAllClients() {
        return clientPersistencePort.getAllClients();
    }

    @Override
    public Account getClient(Long id) {
        return clientPersistencePort.getClient(id);
    }

    @Override
    public void updateClient(Account client) {
        client.setIdRole(4l);
        clientPersistencePort.updateClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientPersistencePort.deleteClient(id);
    }
}
