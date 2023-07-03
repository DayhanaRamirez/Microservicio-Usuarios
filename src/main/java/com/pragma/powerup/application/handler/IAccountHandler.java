package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.AccountRequestDto;
import com.pragma.powerup.application.dto.request.AccountUpdateRequestDto;
import com.pragma.powerup.application.dto.response.AccountResponseDto;

import java.util.List;

public interface IAccountHandler {

    void saveAccount(AccountRequestDto accountRequestDto);

    List<AccountResponseDto> getAllAccounts();

    AccountResponseDto getAccount(Long id);

    void updateAccount(AccountUpdateRequestDto accountUpdateRequestDto);

    void deleteAccount(Long id);
}