package com.pragma.powerup.domain;

import com.pragma.powerup.domain.exception.ForbiddenUserException;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IAccountPersistencePort;
import com.pragma.powerup.domain.usecase.AccountUseCase;
import com.pragma.powerup.infrastructure.configuration.security.TokenUtils;
import org.junit.jupiter.api.Assertions;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;

public class AccountUseCaseTest {
    @Mock
    private IAccountPersistencePort accountPersistencePort;
    @Mock
    private TokenUtils tokenUtils;
    @InjectMocks
    private AccountUseCase accountUseCase;

    private Account superAccount;
    private Account account;
    private List<Account> accountList;
    private String token;

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
                1L );
        this.account = new Account(
            2L,
            "nameTest",
            "lastNameTest",
            "123456789",
            "123456789",
            date,
            "emailTest",
            "123456",
            0L );
        this.token = "stringTestToken";
        this.accountList = new ArrayList<Account>();
        this.accountList.add(this.superAccount);
        this.accountList.add(this.account);
    }
//
//    @Test
//    void saveAccountIsSuccessful() {
//
//        //Arrange
//        String email = "emailTest@test.com";
//        when(tokenUtils.getUsernameFromToken(anyString())).thenReturn(email);
//        when(accountPersistencePort.getAccountByEmail(anyString())).thenReturn(this.superAccount);
//        doNothing().when(accountPersistencePort).saveAccount(any(Account.class));
//
//        //Act
//        accountUseCase.saveAccount(this.account, this.token);
//
//        //Assert
//        verify(tokenUtils).getUsernameFromToken(anyString());
//        verify(accountPersistencePort).getAccountByEmail(anyString());
//        verify(accountPersistencePort).saveAccount(any(Account.class));
//    }
//
//    @Test
//    void saveAccountIsNotSuccessful() {
//
//        //Arrange
//        when(tokenUtils.getUsernameFromToken(anyString())).thenReturn(this.token);
//        when(accountPersistencePort.getAccountByEmail(anyString())).thenReturn(this.account);
//
//        //Act
//        final ForbiddenUserException exception = Assertions.assertThrows(ForbiddenUserException.class, () -> {
//            accountUseCase.saveAccount(this.account, this.token);
//        });
//
//        //Assert
//        verify(tokenUtils).getUsernameFromToken(anyString());
//        verify(accountPersistencePort).getAccountByEmail(anyString());
//        assertAll(
//                () -> assertThat(exception.getClass(), is(ForbiddenUserException.class))
//        );
//    }
//
//    @Test
//    void getAllAccountsIsCalledSuccessfully()
//    {
//        //Arrange
//        when(accountPersistencePort.getAllAccounts()).thenReturn(this.accountList);
//
//        //Act
//        List<Account> list = accountUseCase.getAllAccounts();
//
//        //Assert
//        verify(accountPersistencePort).getAllAccounts();
//        assertAll(
//                () -> assertThat(list.size(), is(2))
//        );
//    }
//
//    @Test
//    void getAccountIsCalledSuccessfully()
//    {
//        //Arrange
//        when(accountPersistencePort.getAccount(anyLong())).thenReturn(this.account);
//
//        //Act
//        Account account = accountUseCase.getAccount(2L);
//
//        //Assert
//        verify(accountPersistencePort).getAccount(anyLong());
//        assertAll(
//                () -> assertThat(account.getId(), is(2L))
//        );
//    }
//
//    @Test
//    void updateAccountIsCalledSuccessfully()
//    {
//        //Arrange
//        doNothing().when(accountPersistencePort).updateAccount(any(Account.class));
//
//        //Act
//        accountUseCase.updateAccount(this.account);
//
//        //Assert
//        verify(accountPersistencePort).updateAccount(any(Account.class));
//    }
//
//    @Test
//    void deleteAccountIsCalledSuccessfully()
//    {
//        //Arrange
//        doNothing().when(accountPersistencePort).deleteAccount(anyLong());
//
//        //Act
//        accountUseCase.deleteAccount(2L);
//
//        //Assert
//        verify(accountPersistencePort).deleteAccount(anyLong());
//    }
//
//    @Test
//    void getAccountIdRoleIsCalledSuccessfully()
//    {
//        //Arrange
//        String email = "emailTest@test.com";
//        when(tokenUtils.getUsernameFromToken(anyString())).thenReturn(email);
//        when(accountPersistencePort.getAccountIdRole(anyString())).thenReturn(1L);
//
//        //Act
//        Long idRole = accountUseCase.getAccountIdRole(this.token);
//
//        //Assert
//        verify(accountPersistencePort).getAccountIdRole(anyString());
//        assertAll(
//                () -> assertThat(idRole, is(1L))
//        );
//    }

}
