package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RoleUpdateRequestDto extends ObjectRequestDto{
    @NotNull(message = "El id es requerido")
    private Long id;

    @NotBlank(message = "La descripcion es requerida")
    private String description;
}
