package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.RoleRequestDto;
import com.pragma.powerup.application.dto.request.RoleUpdateRequestDto;
import com.pragma.powerup.application.dto.response.RoleResponseDto;
import com.pragma.powerup.application.handler.IRoleHandler;
import com.pragma.powerup.application.mapper.IObjectRequestMapper;
import com.pragma.powerup.application.mapper.IObjectResponseMapper;
import com.pragma.powerup.domain.api.IRoleServicePort;
import com.pragma.powerup.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandler implements IRoleHandler {

    private final IRoleServicePort roleServicePort;
    private final IObjectRequestMapper objectRequestMapper;
    private final IObjectResponseMapper objectResponseMapper;

    @Override
    public void saveRole(RoleRequestDto roleRequestDto) {
        Role role = objectRequestMapper.roleDtoToRole(roleRequestDto);
        roleServicePort.saveRole(role);
    }

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return objectResponseMapper.roleToRoleDtoList(roleServicePort.getAllRoles());
    }

    @Override
    public RoleResponseDto getRole(Long id) {
        return objectResponseMapper.roleToRoleDto(roleServicePort.getRole(id));
    }

    @Override
    public void updateRole(RoleUpdateRequestDto roleUpdateRequestDto) {
        Role role = roleServicePort.getRole(roleUpdateRequestDto.getId());
        role.setName(roleUpdateRequestDto.getName());
        role.setDescription(roleUpdateRequestDto.getDescription());
        roleServicePort.updateRole(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleServicePort.deleteRole(id);
    }
}
