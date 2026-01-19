package com.jose.library.auth.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
