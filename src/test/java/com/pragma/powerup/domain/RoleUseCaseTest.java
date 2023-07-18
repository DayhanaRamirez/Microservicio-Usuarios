package com.pragma.powerup.domain;
import com.pragma.powerup.domain.model.Role;
import com.pragma.powerup.domain.spi.IRolePersistencePort;
import com.pragma.powerup.domain.usecase.RoleUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;

public class RoleUseCaseTest {

    @Mock
    private IRolePersistencePort rolePersistencePort;
    @InjectMocks
    private RoleUseCase roleUseCase;
    private Role role;
    private List<Role> roleList;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        this.role = new Role(1L, "testName", "testDescription");
        this.roleList = new ArrayList<Role>();
        this.roleList.add(role);
    }

    @Test
    void saveRoleIsSuccessful() {

        //Arrange
        doNothing().when(rolePersistencePort).saveRole(any(Role.class));

        //Act
        roleUseCase.saveRole(this.role);

        //Assert
        verify(rolePersistencePort).saveRole(any(Role.class));
    }

    @Test
    void getAllRolesIsCalledSuccessfully()
    {
        //Arrange
        when(rolePersistencePort.getAllRoles()).thenReturn(this.roleList);

        //Act
        List<Role> list = roleUseCase.getAllRoles();

        //Assert
        verify(rolePersistencePort).getAllRoles();
        assertAll(
                () -> assertThat(list.size(), is(1))
        );
    }

    @Test
    void getRoleIsCalledSuccessfully()
    {
        //Arrange
        when(rolePersistencePort.getRole(anyLong())).thenReturn(this.role);

        //Act
        Role role = roleUseCase.getRole(1L);

        //Assert
        verify(rolePersistencePort).getRole(anyLong());
        assertAll(
                () -> assertThat(role.getId(), is(1L))
        );
    }

    @Test
    void updateRoleIsCalledSuccessfully()
    {
        //Arrange
        doNothing().when(rolePersistencePort).updateRole(any(Role.class));

        //Act
        roleUseCase.updateRole(this.role);

        //Assert
        verify(rolePersistencePort).updateRole(any(Role.class));
    }

    @Test
    void deleteRoleIsCalledSuccessfully()
    {
        //Arrange
        doNothing().when(rolePersistencePort).deleteRole(anyLong());

        //Act
        roleUseCase.deleteRole(2L);

        //Assert
        verify(rolePersistencePort).deleteRole(anyLong());
    }
}
