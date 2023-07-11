package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ClientUpdateRequestDto extends ObjectRequestDto{
    @NotNull(message = "El id es requerido")
    private Long id;

    @NotBlank(message = "El apellido es requerido")
    private String lastName;

    @Pattern(regexp = "^[0-9]+$", message = "EL documento solo debe tener números")
    @NotBlank(message = "El documento es requerido")
    private String document;

    @Size(min = 10, max = 13, message = "El número no puede exceder los 13 caracteres")
    @Pattern(regexp = "^(?:\\+?[0-9]+)$", message = "El telefono solo debe contener números y el signo + al principio")
    @NotBlank(message = "El celular es requerido")
    private String cellphone;

    @Email(message = "Formato de email inválido")
    @NotBlank(message = "El email es requerido")
    private String email;

    @NotBlank(message = "La contraseña es requerida")
    private String password;
}
