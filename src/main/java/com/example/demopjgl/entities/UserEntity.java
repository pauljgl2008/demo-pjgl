package com.example.demopjgl.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
@Data
public class UserEntity {
    @Id
    private String id;

    private String nombre;

    private String celular;

    private String email;

}

