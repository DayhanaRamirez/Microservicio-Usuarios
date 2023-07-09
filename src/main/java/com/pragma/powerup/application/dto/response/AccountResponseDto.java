package com.pragma.powerup.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class AccountResponseDto extends ObjectResponseDto{
    private String lastName;
    private String document;
    private String cellphone;
    private LocalDate birthdate;
    private String email;
    private Long idRole;
}
