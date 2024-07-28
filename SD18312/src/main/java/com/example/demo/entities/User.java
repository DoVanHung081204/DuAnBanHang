package com.example.demo.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @NotBlank(message = "Khong duoc bo trong")
    private String username;
    @NotBlank(message = "Khong duoc bo trong")
    private String password;

}
