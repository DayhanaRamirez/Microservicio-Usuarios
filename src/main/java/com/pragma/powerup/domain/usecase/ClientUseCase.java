package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IClientServicePort;
import com.pragma.powerup.domain.model.Client;
import com.pragma.powerup.domain.spi.IClientPersistencePort;

import java.util.List;

public class ClientUseCase implements IClientServicePort {
    private final IClientPersistencePort clientPersistencePort;

    public ClientUseCase(IClientPersistencePort clientPersistencePort) {
        this.clientPersistencePort = clientPersistencePort;
    }

    @Override
    public void saveClient(Client client) {
        client.setIdRole(4L);
        clientPersistencePort.saveClient(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientPersistencePort.getAllClients();
    }

    @Override
    public Client getClient(Long id) {
        return clientPersistencePort.getClient(id);
    }

    @Override
    public void updateClient(Client client) {
        client.setIdRole(4l);
        clientPersistencePort.updateClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientPersistencePort.deleteClient(id);
    }
}
