package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Client;

import java.util.List;

public interface IClientPersistencePort {
    void saveClient(Client client);

    List<Client> getAllClients();

    Client getClient(Long id);

    void updateClient(Client client);

    void deleteClient(Long id);
}
