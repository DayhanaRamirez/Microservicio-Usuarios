package com.pragma.powerup.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCredentialsDto {
    private String email;
    private String password;
}
