package com.example.demopjgl.dtos.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private String id;

    @NotBlank(message = "El nombre_usuario is obligatorio")
    @JsonProperty("nombre_usuario")
    private String nombreUsuario;

    @JsonProperty("numero_celular")
    private String numeroCelular;

    @NotBlank
    @Email(message = "Formato de correo_electronico inválido")
    @JsonProperty("correo_electronico")
    private String correoElectronico;

}
