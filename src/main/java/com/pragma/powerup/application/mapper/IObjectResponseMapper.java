package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.AccountResponseDto;
import com.pragma.powerup.application.dto.response.ClientResponseDto;
import com.pragma.powerup.application.dto.response.EmployeeResponseDto;
import com.pragma.powerup.application.dto.response.RoleResponseDto;
import com.pragma.powerup.domain.model.Account;
import com.pragma.powerup.domain.model.Client;
import com.pragma.powerup.domain.model.Employee;
import com.pragma.powerup.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IObjectResponseMapper {

    AccountResponseDto accountToAccountDto(Account account);

    List<AccountResponseDto> accountToAccountDtoList(List<Account> accounts);

    RoleResponseDto roleToRoleDto(Role role);

    List<RoleResponseDto> roleToRoleDtoList(List<Role> roles);

    EmployeeResponseDto employeeToEmployeeDtp(Employee employee);

    List<EmployeeResponseDto> employeeToEmployeeDtoList(List<Employee> employees);

    ClientResponseDto clientToClientDto(Client client);

    List<ClientResponseDto> clientToCLientDtoList(List<Client> clients);
}
