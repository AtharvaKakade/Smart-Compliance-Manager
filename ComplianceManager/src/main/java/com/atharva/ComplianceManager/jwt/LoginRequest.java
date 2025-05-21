package com.atharva.ComplianceManager.jwt;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//@Data
public class LoginRequest {
    @NotNull
    @NotBlank
    private String email;
    @NotBlank
    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" + "email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}