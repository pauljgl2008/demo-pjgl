package com.example.demopjgl.mappers;

import com.example.demopjgl.dtos.requests.UserRequestDto;
import com.example.demopjgl.dtos.responses.UserResponseDto;
import com.example.demopjgl.entities.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(source = "nombre", target = "nombreUsuario")
    @Mapping(source = "celular", target = "numeroCelular")
    @Mapping(source = "email", target = "correoElectronico")
    UserResponseDto toUserResponseDto(UserEntity userEntity);

    @Mapping(source = "nombre", target = "nombreUsuario")
    @Mapping(source = "celular", target = "numeroCelular")
    @Mapping(source = "email", target = "correoElectronico")
    UserRequestDto toUserRequestDto(UserEntity userEntity);

    List<UserResponseDto> userListToUserResponseDtoList(List<UserEntity> source);

    @InheritInverseConfiguration
    UserEntity fromUserResponseDto(UserResponseDto source);

    @InheritInverseConfiguration
    UserEntity fromUserRequestDto(UserRequestDto source);

}
