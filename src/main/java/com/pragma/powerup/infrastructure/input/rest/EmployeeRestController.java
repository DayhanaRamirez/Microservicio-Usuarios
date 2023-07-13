package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.AccountRequestDto;
import com.pragma.powerup.application.dto.request.AccountUpdateRequestDto;
import com.pragma.powerup.application.dto.request.EmployeeRequestDto;
import com.pragma.powerup.application.dto.request.EmployeeRequestUpdateDto;
import com.pragma.powerup.application.dto.response.AccountResponseDto;
import com.pragma.powerup.application.dto.response.EmployeeResponseDto;
import com.pragma.powerup.application.dto.response.ObjectResponseDto;
import com.pragma.powerup.application.handler.IEmployeeHandler;
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
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final IEmployeeHandler employeeHandler;

    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> saveEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto, @RequestHeader("Authorization") String authHeader) {
        employeeHandler.saveEmployee(employeeRequestDto, authHeader);
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
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeHandler.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployee(@PathVariable("id") long id) {
        return ResponseEntity.ok(employeeHandler.getEmployee(id));
    }

    @PutMapping
    public ResponseEntity<Void> updateEmployee(@Valid @RequestBody EmployeeRequestUpdateDto employeeRequestUpdateDto){
        employeeHandler.updateEmployee(employeeRequestUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
        employeeHandler.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
