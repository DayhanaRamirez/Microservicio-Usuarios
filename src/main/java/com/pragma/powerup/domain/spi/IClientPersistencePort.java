package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Client;

import java.util.List;

public interface IClientPersistencePort {
    void saveClient(Account account);

    List<Account> getAllClients();

    Account getClient(Long id);

    void updateClient(Account account);

    void deleteClient(Long id);

    Account getAccountByEmail(String email);
}
