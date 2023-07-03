package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.RoleRequestDto;
import com.pragma.powerup.application.dto.request.RoleUpdateRequestDto;
import com.pragma.powerup.application.dto.response.RoleResponseDto;

import java.util.List;

public interface IRoleHandler {
    void saveRole(RoleRequestDto roleRequestDto);

    List<RoleResponseDto> getAllRoles();

    RoleResponseDto getRole(Long id);

    void updateRole(RoleUpdateRequestDto roleUpdateRequestDto);

    void deleteRole(Long id);

}
