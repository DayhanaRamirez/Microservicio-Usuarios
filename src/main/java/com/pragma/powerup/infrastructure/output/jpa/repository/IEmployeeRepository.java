package com.pragma.powerup.infrastructure.output.jpa.repository;

import com.pragma.powerup.infrastructure.output.jpa.entity.AccountEntity;
import com.pragma.powerup.infrastructure.output.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findFirstByEmail(String email);
}
