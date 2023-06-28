package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Role;
import java.util.List;

public interface IRoleServicePort {
    void saveRole(Role role);

    List<Role> getAllRoles();

    Role getRole(Long id);

    void updateRole(Role role);

    void deleteRole(Long id);
}
