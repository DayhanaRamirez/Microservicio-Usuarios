package com.pragma.powerup.domain;

import com.pragma.powerup.domain.exception.ForbiddenUserException;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IEmployeePersistencePort;
import com.pragma.powerup.domain.usecase.EmployeeUseCase;
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
public class EmployeeUseCaseTest {

    @Mock
    private IEmployeePersistencePort employeePersistencePort;

    @Mock
    private TokenUtils tokenUtils;

    @InjectMocks
    private EmployeeUseCase employeeUseCase;

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
                2L );
        this.account = new Account(
                2L,
                "nameTest",
                "lastNameTest",
                "123456789",
                "123456789",
                date,
                "emailTest",
                "123456",
                3L );
        this.token = "stringTestToken";
        this.accountList = new ArrayList<Account>();
        this.accountList.add(this.superAccount);
        this.accountList.add(this.account);
    }

    @Test
    void saveEmployeeIsSuccessful() {

        //Arrange
        String email = "emailTest@test.com";
        when(tokenUtils.getUsernameFromToken(anyString())).thenReturn(email);
        when(employeePersistencePort.getAccountByEmail(anyString())).thenReturn(this.superAccount);
        doNothing().when(employeePersistencePort).saveEmployee(any(Account.class));

        //Act
        employeeUseCase.saveEmployee(this.account, this.token);

        //
        verify(tokenUtils).getUsernameFromToken(anyString());
        verify(employeePersistencePort).getAccountByEmail(anyString());
        verify(employeePersistencePort).saveEmployee(any(Account.class));
    }

    @Test
    void saveEmployeeIsNotSuccessful() {

        //Arrange
        when(tokenUtils.getUsernameFromToken(anyString())).thenReturn(this.token);
        when(employeePersistencePort.getAccountByEmail(anyString())).thenReturn(this.account);

        //Act
        final ForbiddenUserException exception = Assertions.assertThrows(ForbiddenUserException.class, () -> {
            employeeUseCase.saveEmployee(this.account, this.token);
        });

        //Assert
        verify(tokenUtils).getUsernameFromToken(anyString());
        verify(employeePersistencePort).getAccountByEmail(anyString());
        assertAll(
                () -> assertThat(exception.getClass(), is(ForbiddenUserException.class))
        );
    }

    @Test
    void getAllEmployeesIsCalledSuccessfully()
    {
        //Arrange
        when(employeePersistencePort.getAllEmployees()).thenReturn(this.accountList);

        //Act
        List<Account> list = employeeUseCase.getAllEmployees();

        //Assert
        verify(employeePersistencePort).getAllEmployees();
        assertAll(
                () -> assertThat(list.size(), is(2))
        );
    }


    @Test
    void getEmployeeIsCalledSuccessfully()
    {
        //Arrange
        when(employeePersistencePort.getEmployee(anyLong())).thenReturn(this.account);

        //Act
        Account account = employeeUseCase.getEmployee(2L);

        //Assert
        verify(employeePersistencePort).getEmployee(anyLong());
        assertAll(
                () -> assertThat(account.getId(), is(2L))
        );
    }


    @Test
    void updateEmployeeIsCalledSuccessfully()
    {
        //Arrange
        doNothing().when(employeePersistencePort).updateEmployee(any(Account.class));

        //Act
        employeeUseCase.updateEmployee(this.account);

        //Assert
        verify(employeePersistencePort).updateEmployee(any(Account.class));
    }


    @Test
    void deleteEmployeeIsCalledSuccessfully()
    {
        //Arrange
        doNothing().when(employeePersistencePort).deleteEmployee(anyLong());

        //Act
        employeeUseCase.deleteEmployee(1L);

        //Assert
        verify(employeePersistencePort).deleteEmployee(anyLong());
    }
}
