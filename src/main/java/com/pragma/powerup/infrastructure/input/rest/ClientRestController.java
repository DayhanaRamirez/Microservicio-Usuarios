package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.AccountRequestDto;
import com.pragma.powerup.application.dto.request.AccountUpdateRequestDto;
import com.pragma.powerup.application.dto.request.ClientRequestDto;
import com.pragma.powerup.application.dto.request.ClientUpdateRequestDto;
import com.pragma.powerup.application.dto.response.AccountResponseDto;
import com.pragma.powerup.application.dto.response.ClientResponseDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.handler.IClientHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientRestController {

    private final IClientHandler clientHandler;


    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> saveClient(@Valid @RequestBody ClientRequestDto clientRequestDto, @RequestHeader("Authorization") String authHeader) {
        clientHandler.saveClient(clientRequestDto, authHeader);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all objects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ObjectResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        return ResponseEntity.ok(clientHandler.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getClient(@PathVariable("id") long id) {
        return ResponseEntity.ok(clientHandler.getClient(id));
    }

    @PutMapping
    public ResponseEntity<Void> updateClient(@Valid @RequestBody ClientUpdateRequestDto clientUpdateRequestDto){
        clientHandler.updateClient(clientUpdateRequestDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id){
        clientHandler.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
