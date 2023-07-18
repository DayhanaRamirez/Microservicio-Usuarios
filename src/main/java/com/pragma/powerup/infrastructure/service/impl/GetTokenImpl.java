package com.pragma.powerup.infrastructure.service.impl;

import com.pragma.powerup.domain.api.IGetToken;
import com.pragma.powerup.infrastructure.configuration.security.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetTokenImpl implements IGetToken {

    private final TokenUtils tokenUtils;

    @Override
    public String getUsernameFromToken(String token) {
        return tokenUtils.getUsernameFromToken(token);
    }
}
