package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.AccountRequestDto;
import com.pragma.powerup.application.dto.request.RoleRequestDto;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IObjectRequestMapper {
    Account accountDtoToAccount(AccountRequestDto accountRequestDto);
    Role roleDtoToRole(RoleRequestDto roleRequestDto);

}
