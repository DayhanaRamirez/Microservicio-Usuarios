package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IAccountServicePort;
import com.pragma.powerup.domain.api.IRoleServicePort;
import com.pragma.powerup.domain.spi.IAccountPersistencePort;
import com.pragma.powerup.domain.spi.IRolePersistencePort;
import com.pragma.powerup.domain.usecase.AccountUseCase;
import com.pragma.powerup.domain.usecase.RoleUseCase;
import com.pragma.powerup.infrastructure.output.jpa.adapter.AccountJpaAdapter;
import com.pragma.powerup.infrastructure.output.jpa.adapter.RoleJpaAdapter;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IAccountEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IRoleEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.IAccountRepository;
import com.pragma.powerup.infrastructure.output.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IAccountRepository accountRepository;
    private final IAccountEntityMapper accountEntityMapper;
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Bean
    public IAccountPersistencePort accountPersistencePort(){
        return new AccountJpaAdapter(accountRepository, accountEntityMapper);
    }
    @Bean
    public IAccountServicePort accountServicePort() {
        return new AccountUseCase(accountPersistencePort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort(){
        return new RoleJpaAdapter(roleRepository, roleEntityMapper);
    }
    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }

}