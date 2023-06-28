package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.AccountResponseDto;
import com.pragma.powerup.application.dto.response.RoleResponseDto;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IObjectResponseMapper {

    AccountResponseDto accountToAccountDto(Account account);

    List<AccountResponseDto> AccountToAccountDtoList(List<Account> accounts);

    RoleResponseDto roleToRoleDto(Role role);
}
