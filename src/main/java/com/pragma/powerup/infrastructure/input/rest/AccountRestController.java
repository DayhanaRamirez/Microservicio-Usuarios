package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.AccountRequestDto;
import com.pragma.powerup.application.dto.request.AccountUpdateRequestDto;
import com.pragma.powerup.application.dto.response.AccountResponseDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.handler.IAccountHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.InetSocketAddress;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountRestController {

    private final IAccountHandler accountHandler;

    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> saveAccount(@Valid @RequestBody AccountRequestDto accountRequestDto, @RequestHeader("Authorization") String authHeader) {
        accountHandler.saveAccount(accountRequestDto, authHeader);
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
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts() {
        return ResponseEntity.ok(accountHandler.getAllAccounts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> getAccount(@PathVariable("id") long id) {
        return ResponseEntity.ok(accountHandler.getAccount(id));
    }

    @PutMapping
    public ResponseEntity<Void> updateAccount(@Valid @RequestBody AccountUpdateRequestDto accountUpdateRequestDto){
        accountHandler.updateAccount(accountUpdateRequestDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id){
        accountHandler.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/role")
    public ResponseEntity<Long> getAccountId(@RequestHeader("Authorization") String authHeader){;
        System.out.println("Hola");
        return ResponseEntity.ok(accountHandler.getAccountIdRole(authHeader));
    }

    @GetMapping("/roleAndId")
    public ResponseEntity<Long[]> getUserIdAndRole(@RequestHeader("Authorization") String authHeader){;
        return ResponseEntity.ok(accountHandler.getUserIdAndRole(authHeader));
    }



}