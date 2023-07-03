package com.pragma.powerup.infrastructure.output.jpa.adapter;

import com.pragma.powerup.domain.model.Role;
import com.pragma.powerup.domain.spi.IRolePersistencePort;
import com.pragma.powerup.infrastructure.exception.*;
import com.pragma.powerup.infrastructure.output.jpa.entity.RoleEntity;
import com.pragma.powerup.infrastructure.output.jpa.mapper.IRoleEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {

    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Override
    public void saveRole(Role role) {
        roleRepository.save(roleEntityMapper.roleToEntity(role));
    }

    @Override
    public List<Role> getAllRoles() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        if(roleEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return roleEntityMapper.entitiesToRoleList(roleEntityList);
    }

    @Override
    public Role getRole(Long id) {
        return roleEntityMapper.entityToRole(roleRepository.findById(id)
                .orElseThrow(RoleNotFoundException::new));
    }

    @Override
    public void updateRole(Role role) {
        roleRepository.save(roleEntityMapper.roleToEntity(role));
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
