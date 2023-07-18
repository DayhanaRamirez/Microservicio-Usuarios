package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.AccountRequestDto;
import com.pragma.powerup.application.dto.request.AccountUpdateRequestDto;
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
    public void saveAccount(AccountRequestDto accountRequestDto, String token) {
        Account account = objectRequestMapper.accountDtoToAccount(accountRequestDto);
        account.setPassword(encryptService.encryptPassword(accountRequestDto.getPassword()));
        accountServicePort.saveAccount(account, trimToken(token));
    }

    @Override
    public List<AccountResponseDto> getAllAccounts() {
        return objectResponseMapper.accountToAccountDtoList(accountServicePort.getAllAccounts());
    }

    @Override
    public AccountResponseDto getAccount(Long id) {
        Account account = accountServicePort.getAccount(id);
        return objectResponseMapper.accountToAccountDto(account);
    }

    @Override
    public void updateAccount(AccountUpdateRequestDto accountUpdateRequestDto) {
        Account account = accountServicePort.getAccount(accountUpdateRequestDto.getId());
        account.setName(accountUpdateRequestDto.getName());
        account.setLastName(accountUpdateRequestDto.getLastName());
        account.setDocument(accountUpdateRequestDto.getDocument());
        account.setCellphone(accountUpdateRequestDto.getCellphone());
        account.setBirthdate(accountUpdateRequestDto.getBirthdate());
        account.setEmail(accountUpdateRequestDto.getEmail());
        account.setPassword(encryptService.encryptPassword(accountUpdateRequestDto.getPassword()));
        account.setIdRole(2L);
        accountServicePort.updateAccount(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountServicePort.deleteAccount(id);
    }

    @Override
    public Long getAccountIdRole(String token) {
        return accountServicePort.getAccountIdRole(trimToken(token));
    }

    @Override
    public Long[] getUserIdAndRole(String token) {
        return accountServicePort.getUserIdAndRole(token);
    }

    private String trimToken(String token){
        if (token.startsWith("Bearer ")) {
            token = token.split(" ")[1].trim();
        }
        return token;
    }


}