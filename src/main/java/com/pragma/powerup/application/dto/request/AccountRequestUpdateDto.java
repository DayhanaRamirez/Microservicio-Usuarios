package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AccountRequestUpdateDto extends ObjectRequestDto {
    @NotNull(message = "El id es requerido")
    private Long id;

    @NotBlank(message = "El apellido es requerido")
    private String lastName;

    @NotNull(message = "El documento es requerido")
    private int document;

    @Max(value = 13, message = "El número no puede exceder los 13 caracteres")
    @NotBlank(message = "El celular es requerido")
    private String cellphone;

    @NotBlank(message = "La fecha de nacimiento es requerida")
    private String birthdate;

    @Email(message = "Formato de email inválido")
    @NotBlank(message = "El email es requerido")
    private String email;

    @NotBlank(message = "La contraseña es requerida")
    private String password;

}
