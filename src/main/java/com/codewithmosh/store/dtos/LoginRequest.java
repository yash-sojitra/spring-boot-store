package com.codewithmosh.store.dtos;

import com.codewithmosh.store.validation.Lowercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "email is required")
    @Email(message = "email must be valid")
    @Lowercase(message = "email must be in lowercase")
    private String email;

    @NotBlank(message = "password is required")
    @Size(min = 6, max = 25, message = "password must be between 6 to 25 characters long.")
    private String password;
}
