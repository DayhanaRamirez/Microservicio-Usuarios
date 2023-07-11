package com.pragma.powerup.infrastructure.output.jpa.repository;

import com.pragma.powerup.infrastructure.output.jpa.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
}
