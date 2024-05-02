package com.romeoh20.goalhub.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 25, message = "Invalid username. Must be between 3 and 25 characters")
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 10, max = 30, message = "Invalid password. Must be between 10 and 30 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
