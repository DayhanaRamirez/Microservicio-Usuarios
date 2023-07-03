package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.RoleRequestDto;
import com.pragma.powerup.application.dto.request.RoleUpdateRequestDto;
import com.pragma.powerup.application.dto.response.RoleResponseDto;
import com.pragma.powerup.application.handler.IRoleHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleRestController {

    private final IRoleHandler roleHandler;

    @PostMapping
    public ResponseEntity<Void> saveRole(@Valid @RequestBody RoleRequestDto roleRequestDto) {
        roleHandler.saveRole(roleRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getAllRoles() {
        return ResponseEntity.ok(roleHandler.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable("id") long id) {
        return ResponseEntity.ok(roleHandler.getRole(id));
    }

    @PutMapping
    public ResponseEntity<Void> updateRole(@Valid @RequestBody RoleUpdateRequestDto roleUpdateRequestDto){
        roleHandler.updateRole(roleUpdateRequestDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable("id") Long id){
        roleHandler.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

}
