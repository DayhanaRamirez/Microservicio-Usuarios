package com.pragma.powerup.infrastructure.output.jpa.mapper;

import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.infrastructure.output.jpa.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IAccountEntityMapper {

    AccountEntity accountToEntity(Account account);
    Account entityToAccount(AccountEntity accountEntity);
    List<Account> entityToAccountList(List<AccountEntity> accountEntityList);
}