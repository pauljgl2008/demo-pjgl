package com.example.demopjgl.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UsuarioRequestDto{
    private String id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String celular;

    @NotBlank(message = "El email es obligatorio")
    private String email;

}
