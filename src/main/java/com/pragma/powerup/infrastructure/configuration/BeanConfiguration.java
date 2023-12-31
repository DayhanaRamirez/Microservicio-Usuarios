package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.*;
import com.pragma.powerup.domain.spi.*;
import com.pragma.powerup.domain.usecase.AccountUseCase;
import com.pragma.powerup.domain.usecase.ClientUseCase;
import com.pragma.powerup.domain.usecase.EmployeeUseCase;
import com.pragma.powerup.domain.usecase.RoleUseCase;
import com.pragma.powerup.infrastructure.configuration.security.TokenUtils;
import com.pragma.powerup.infrastructure.output.jpa.adapter.AccountJpaAdapter;
import com.pragma.powerup.infrastructure.output.jpa.adapter.ClientJpaAdapter;
import com.pragma.powerup.infrastructure.output.jpa.adapter.EmployeeJpaAdapter;
import com.pragma.powerup.infrastructure.output.jpa.adapter.RoleJpaAdapter;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IAccountEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IClientEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IEmployeeEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IRoleEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.IAccountRepository;
import com.pragma.powerup.infrastructure.output.jpa.repository.IClientRepository;
import com.pragma.powerup.infrastructure.output.jpa.repository.IEmployeeRepository;
import com.pragma.powerup.infrastructure.output.jpa.repository.IRoleRepository;
import com.pragma.powerup.infrastructure.service.impl.EncryptServiceImpl;
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
    private final IEncryptService encryptService;
    private final IClientRepository clientRepository;
    private final IClientEntityMapper clientEntityMapper;
    private final IEmployeeRepository employeeRepository;
    private final IEmployeeEntityMapper employeeEntityMapper;
    private final TokenUtils tokenUtils;
    private final IGetToken getToken;

    @Bean
    public IAccountPersistencePort accountPersistencePort(){
        return new AccountJpaAdapter(accountRepository,roleRepository, accountEntityMapper, roleEntityMapper);
    }
    @Bean
    public IAccountServicePort accountServicePort() {
        return new AccountUseCase(accountPersistencePort(), getToken);
    }

    @Bean
    public IRolePersistencePort rolePersistencePort(){
        return new RoleJpaAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public IClientPersistencePort clientPersistencePort(){
        return new ClientJpaAdapter(clientRepository, clientEntityMapper, roleRepository, roleEntityMapper);
    }

    @Bean
    public IClientServicePort clientServicePort(){
        return new ClientUseCase(clientPersistencePort(), tokenUtils);
    }

    @Bean
    public IEmployeePersistencePort employeePersistencePort(){
        return new EmployeeJpaAdapter(employeeRepository, employeeEntityMapper, roleRepository, roleEntityMapper);
    }

    @Bean
    public IEmployeeServicePort employeeServicePort(){
        return new EmployeeUseCase(employeePersistencePort(), tokenUtils);
    }

    @Bean
    public IEncryptService encryptService(){
        return new EncryptServiceImpl();
    }
}