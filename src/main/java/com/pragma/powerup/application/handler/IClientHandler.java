package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.ClientRequestDto;
import com.pragma.powerup.application.dto.request.ClientUpdateRequestDto;
import com.pragma.powerup.application.dto.response.ClientResponseDto;

import java.util.List;

public interface IClientHandler {

    void saveClient(ClientRequestDto clientRequestDto);

    List<ClientResponseDto> getAllClients();

    ClientResponseDto getClient(Long id);

    void updateClient(ClientUpdateRequestDto clientUpdateRequestDto);

    void deleteClient(Long id);

}
