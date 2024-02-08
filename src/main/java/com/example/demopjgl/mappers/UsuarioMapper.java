package com.example.demopjgl.mappers;

import com.example.demopjgl.dtos.requests.UsuarioRequestDto;
import com.example.demopjgl.dtos.responses.UsuarioResponseDto;
import com.example.demopjgl.entities.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class );

    @Mapping(source = "nombre", target = "nombreUsuario")
    @Mapping(source = "celular", target = "numeroCelular")
    @Mapping(source = "email", target = "correoElectronico")
    UsuarioResponseDto toUsuarioResponseDto(UsuarioEntity usuarioEntity);

    @Mapping(source = "nombre", target = "nombreUsuario")
    @Mapping(source = "celular", target = "numeroCelular")
    @Mapping(source = "email", target = "correoElectronico")
    UsuarioRequestDto toUsuarioRequestDto(UsuarioEntity usuarioEntity);

    List<UsuarioResponseDto> usuarioListToUsuarioResponseDtoList(List<UsuarioEntity> source);

    @InheritInverseConfiguration
    UsuarioEntity fromUsuarioResponseDto(UsuarioResponseDto source);

    @InheritInverseConfiguration
    UsuarioEntity fromUsuarioRequestDto(UsuarioRequestDto source);

}
