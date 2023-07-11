package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.ClientRequestDto;
import com.pragma.powerup.application.dto.request.ClientUpdateRequestDto;
import com.pragma.powerup.application.dto.response.ClientResponseDto;
import com.pragma.powerup.application.handler.IClientHandler;
import com.pragma.powerup.application.mapper.IObjectRequestMapper;
import com.pragma.powerup.application.mapper.IObjectResponseMapper;
import com.pragma.powerup.domain.api.IClientServicePort;
import com.pragma.powerup.domain.model.Client;
import com.pragma.powerup.domain.spi.IEncryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientHandler implements IClientHandler {

    private final IClientServicePort clientServicePort;
    private final IObjectRequestMapper objectRequestMapper;
    private final IObjectResponseMapper objectResponseMapper;
    private final IEncryptService encryptService;

    @Override
    public void saveClient(ClientRequestDto clientRequestDto) {
        Client client = objectRequestMapper.clientDtoToClient(clientRequestDto);
        client.setPassword(encryptService.encryptPassword(clientRequestDto.getPassword()));
        clientServicePort.saveClient(client);

    }

    @Override
    public List<ClientResponseDto> getAllClients() {
        return objectResponseMapper.clientToCLientDtoList(clientServicePort.getAllClients());
    }

    @Override
    public ClientResponseDto getClient(Long id) {
        return objectResponseMapper.clientToClientDto(clientServicePort.getClient(id));
    }

    @Override
    public void updateClient(ClientUpdateRequestDto clientUpdateRequestDto) {
        Client client = clientServicePort.getClient(clientUpdateRequestDto.getId());
        client.setName(clientUpdateRequestDto.getName());
        client.setLastName(clientUpdateRequestDto.getLastName());
        client.setDocument(clientUpdateRequestDto.getDocument());
        client.setCellphone(clientUpdateRequestDto.getCellphone());
        client.setPassword(encryptService.encryptPassword(clientUpdateRequestDto.getPassword()));
        clientServicePort.updateClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientServicePort.deleteClient(id);
    }
}
