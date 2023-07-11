package com.pragma.powerup.infrastructure.output.jpa.mapper;

import com.pragma.powerup.domain.model.Employee;
import com.pragma.powerup.infrastructure.output.jpa.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IEmployeeEntityMapper {
    EmployeeEntity employeeToEntity(Employee employee);

    Employee entityToEmployee(EmployeeEntity employeeEntity);

    List<Employee> entitiesToEmployeeList(List<EmployeeEntity> employeeEntityList);
}
