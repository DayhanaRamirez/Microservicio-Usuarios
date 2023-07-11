package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Client;

import java.util.List;

public interface IClientServicePort {
    void saveClient(Client client);

    List<Client> getAllClients();

    Client getClient(Long id);

    void updateClient(Client client);

    void deleteClient(Long id);
}
