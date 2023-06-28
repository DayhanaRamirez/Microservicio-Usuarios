package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.AccountRequestDto;
import com.pragma.powerup.application.dto.request.AccountRequestUpdateDto;
import com.pragma.powerup.application.dto.response.AccountResponseDto;

import java.util.List;

public interface IAccountHandler {

    void saveAccount(AccountRequestDto accountRequestDto);

    List<AccountResponseDto> getAllAccounts();

    AccountResponseDto getAccount(Long id);

    void updateAccount(AccountRequestUpdateDto accountRequestUpdateDto);

    void deleteAccount(Long id);
}