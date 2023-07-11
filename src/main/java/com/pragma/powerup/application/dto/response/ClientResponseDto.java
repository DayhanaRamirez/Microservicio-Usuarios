package com.pragma.powerup.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseDto extends ObjectResponseDto{
    private String lastName;
    private String document;
    private String cellphone;
    private String email;
    private Long idRole;
}
