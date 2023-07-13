package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Client;

import java.util.List;

public interface IClientServicePort {
    void saveClient(Account account, String token);

    List<Account> getAllClients();

    Account getClient(Long id);

    void updateClient(Account account);

    void deleteClient(Long id);
}
