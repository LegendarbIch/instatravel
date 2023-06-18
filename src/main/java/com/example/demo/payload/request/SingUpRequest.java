package com.example.demo.payload.request;

import com.example.demo.annotations.PasswordMatches;
import com.example.demo.annotations.ValidEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatches
public class SingUpRequest {

    @Email(message = "Формат должен соотвествовать email")
    @NotBlank(message = "Требуется электронная почта пользователя")
    @ValidEmail
    public String email;
    @NotEmpty(message = "Введите свое имя")
    private String firstname;
    @NotEmpty(message = "Введите фамилию")
    private String lastname;
    @NotEmpty(message = "Введите никнейм")
    private String username;
    @NotEmpty(message = "Требуется пароль")
    @Size(min = 4)
    private String password;
    private String  confirmedPassword;
}
