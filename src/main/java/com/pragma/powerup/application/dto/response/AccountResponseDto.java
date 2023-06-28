package com.pragma.powerup.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponseDto extends ObjectResponseDto{
    private String lastName;
    private int document;
    private String cellphone;
    private String birthdate;
    private String email;
}
