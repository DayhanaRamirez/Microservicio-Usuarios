package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.AccountRequestDto;
import com.pragma.powerup.application.dto.request.AccountRequestUpdateDto;
import com.pragma.powerup.application.dto.response.AccountResponseDto;
import com.pragma.powerup.application.handler.IAccountHandler;
import com.pragma.powerup.application.mapper.IObjectRequestMapper;
import com.pragma.powerup.application.mapper.IObjectResponseMapper;
import com.pragma.powerup.domain.api.IAccountServicePort;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.spi.IEncryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountHandler implements IAccountHandler {

    private final IAccountServicePort accountServicePort;
    private final IObjectRequestMapper objectRequestMapper;
    private final IObjectResponseMapper objectResponseMapper;
    private final IEncryptService encryptService;

    @Override
    public void saveAccount(AccountRequestDto accountRequestDto) {
        Account account = objectRequestMapper.accountDtoToAccount(accountRequestDto);
        account.setPassword(encryptService.encryptPassword(accountRequestDto.getPassword()));
        accountServicePort.saveAccount(account);
    }

    @Override
    public List<AccountResponseDto> getAllAccounts() {
        return objectResponseMapper.AccountToAccountDtoList(accountServicePort.getAllAccounts());
    }

    @Override
    public AccountResponseDto getAccount(Long id) {
        Account account = accountServicePort.getAccount(id);
        return objectResponseMapper.accountToAccountDto(account);
    }

    @Override
    public void updateAccount(AccountRequestUpdateDto accountRequestUpdateDto) {
        Account account = accountServicePort.getAccount(accountRequestUpdateDto.getId());
        account.setName(accountRequestUpdateDto.getName());
        account.setLastName(accountRequestUpdateDto.getLastName());
        account.setDocument(accountRequestUpdateDto.getDocument());
        account.setCellphone(accountRequestUpdateDto.getCellphone());
        account.setBirthdate(accountRequestUpdateDto.getBirthdate());
        account.setEmail(accountRequestUpdateDto.getEmail());
        account.setPassword(encryptService.encryptPassword(accountRequestUpdateDto.getPassword()));
        accountServicePort.updateAccount(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountServicePort.deleteAccount(id);
    }
}