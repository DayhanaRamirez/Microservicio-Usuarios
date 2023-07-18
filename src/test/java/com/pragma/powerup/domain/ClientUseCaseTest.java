package com.pragma.powerup.domain;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IClientPersistencePort;
import com.pragma.powerup.domain.usecase.ClientUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class ClientUseCaseTest {
    @Mock
    private IClientPersistencePort clientPersistencePort;
    @InjectMocks
    private ClientUseCase clientUseCase;

    private Account superAccount;
    private Account account;
    private List<Account> accountList;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
        LocalDate date = LocalDate.of(1996, 06, 01);
        this.superAccount = new Account(
                1L,
                "nameTest",
                "lastNameTest",
                "123456789",
                "123456789",
                date,
                "emailTest",
                "123456",
                4L );
        this.account = new Account(
                2L,
                "nameTest",
                "lastNameTest",
                "123456789",
                "123456789",
                date,
                "emailTest",
                "123456",
                4L );
        this.accountList = new ArrayList<Account>();
        this.accountList.add(this.superAccount);
        this.accountList.add(this.account);
    }


    @Test
    void saveAccountIsSuccessful() {

        //Arrange
        doNothing().when(clientPersistencePort).saveClient(any(Account.class));

        //Act
        clientUseCase.saveClient(this.account);

        //Assert
        verify(clientPersistencePort).saveClient(any(Account.class));
    }

    @Test
    void getAllAccountsIsCalledSuccessfully()
    {
        //Arrange
        when(clientPersistencePort.getAllClients()).thenReturn(this.accountList);

        //Act
        List<Account> list = clientUseCase.getAllClients();

        //Assert
        verify(clientPersistencePort).getAllClients();
        assertAll(
                () -> assertThat(list.size(), is(2))
        );
    }

    @Test
    void getAccountIsCalledSuccessfully()
    {
        //Arrange
        when(clientPersistencePort.getClient(anyLong())).thenReturn(this.account);

        //Act
        Account account = clientUseCase.getClient(2L);

        //Assert
        verify(clientPersistencePort).getClient(anyLong());
        assertAll(
                () -> assertThat(account.getId(), is(2L))
        );
    }

    @Test
    void updateAccountIsCalledSuccessfully()
    {
        //Arrange
        doNothing().when(clientPersistencePort).updateClient(any(Account.class));

        //Act
        clientUseCase.updateClient(this.account);

        //Assert
        verify(clientPersistencePort).updateClient(any(Account.class));
    }

    @Test
    void deleteAccountIsCalledSuccessfully()
    {
        //Arrange
        doNothing().when(clientPersistencePort).deleteClient(anyLong());

        //Act
        clientUseCase.deleteClient(2L);

        //Assert
        verify(clientPersistencePort).deleteClient(anyLong());
    }
}
