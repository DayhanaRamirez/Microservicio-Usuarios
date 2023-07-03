package com.pragma.powerup.application.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccountResponseDto extends ObjectResponseDto{
    private String lastName;
    private String document;
    private String cellphone;
    private LocalDate birthdate;
    private String email;
}
