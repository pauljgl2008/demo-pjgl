package com.example.demopjgl.mappers;

import com.example.demopjgl.dtos.responses.UsuarioResponseDto;
import com.example.demopjgl.entities.UsuarioEntity;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    @Mappings({@Mapping(source = "nombre", target = "nombreUsuario"),
            @Mapping(source = "celular", target = "numeroCelular"),
            @Mapping(source = "email", target = "correoElectronico")})
    UsuarioResponseDto toUsuarioResponseDto(UsuarioEntity usuarioEntity);

    List<UsuarioResponseDto> usuarioListToUsuarioResponseDtoList(List<UsuarioEntity> source);

    @InheritInverseConfiguration
    UsuarioEntity fromUsuarioResponseDto(UsuarioResponseDto usuarioDto);

}
