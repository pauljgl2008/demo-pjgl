package com.example.demopjgl.entities;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuarios")
public class UsuarioEntity {
    @Id
    private String id;

    private String nombre;

    private String celular;

    private String email;

}

