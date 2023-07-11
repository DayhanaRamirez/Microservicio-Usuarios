package com.pragma.powerup.infrastructure.output.jpa.mapper;

import com.pragma.powerup.domain.model.Client;
import com.pragma.powerup.infrastructure.output.jpa.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IClientEntityMapper {
    ClientEntity clientToEntity(Client client);
    Client entityToClient(ClientEntity clientEntity);

    List<Client> entitiesToClientList(List<ClientEntity> clientEntityList);
}
