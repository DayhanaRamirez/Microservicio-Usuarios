package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IAccountPersistencePort;
import com.pragma.powerup.infrastructure.output.jpa.adapter.AccountJpaAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AccountUseCaseTest {

    @Mock
    private IAccountPersistencePort accountPersistencePort;
    private AccountUseCase accountUseCase;
    private Account account;

    @BeforeEach
    void setUp(){
        accountUseCase = new AccountUseCase(accountPersistencePort);
        MockitoAnnotations.openMocks(this);
        this.account = new Account(
                1L,
                "Dayhana",
                "Ramirez",
                "1152458596",
                "+573218423105",
                LocalDate.of(1996, 06, 01), "dayhanaramirez45@gmail.com", "123456", 1L)
    }

    @Test
    void givenIdWhenGettingAccountThenReturnAccount() {
        //Arrange
        when(accountPersistencePort.getAccount(anyLong())).thenReturn(account);

        //Act
        Account response = accountUseCase.getAccount(1L);

        //Assert
        verify()
    }

    @Test
    void getAllAccounts() {
    }

    @Test
    void getAccount() {
    }

    @Test
    void updateAccount() {
    }

    @Test
    void deleteAccount() {
    }

    @Test
    void testSaveAccount() {
    }

    @Test
    void testGetAllAccounts() {
    }

    @Test
    void testGetAccount() {
    }

    @Test
    void testUpdateAccount() {
    }

    @Test
    void testDeleteAccount() {
    }
}