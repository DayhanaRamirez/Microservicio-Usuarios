package com.pragma.powerup.infrastructure.output.jpa.mapper;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Client;
import com.pragma.powerup.infrastructure.output.jpa.entity.AccountEntity;
import com.pragma.powerup.infrastructure.output.jpa.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IClientEntityMapper {
    AccountEntity clientToEntity(Account client);
    Account entityToClient(AccountEntity clientEntity);

    List<Account> entitiesToClientList(List<AccountEntity> clientEntityList);
}
