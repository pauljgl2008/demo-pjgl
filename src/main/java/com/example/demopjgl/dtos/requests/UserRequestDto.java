package com.example.demopjgl.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String id;

    @NotBlank
    @JsonProperty("nombre_usuario")
    private String nombreUsuario;

    private String numeroCelular;

    //@NotBlank
    //@Email
    //@JsonProperty("correo_electronico")
    private String correoElectronico;

}
