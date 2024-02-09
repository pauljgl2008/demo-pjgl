package com.example.demopjgl.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserResponseDto {

    @JsonProperty("nombre_usuario")
    private String nombreUsuario;

    @JsonProperty("celular")
    private String numeroCelular;

    @JsonProperty("correo_electronico")
    private String correoElectronico;


}
