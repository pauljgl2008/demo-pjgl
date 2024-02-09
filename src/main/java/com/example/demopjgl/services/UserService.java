package com.example.demopjgl.services;

import com.example.demopjgl.dtos.requests.UserRequestDto;
import com.example.demopjgl.dtos.responses.UserResponseDto;
import com.example.demopjgl.entities.UserEntity;
import com.example.demopjgl.mappers.UserMapper;
import com.example.demopjgl.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return userMapper.userListToUserResponseDtoList(users);
    }

    public UserResponseDto updateUser(UserRequestDto userRequestDto, String id) throws Exception {
        UserEntity usuario = userRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuario no encontrado con ID: " + id));
        usuario.setNombre(userRequestDto.getNombreUsuario());
        usuario.setEmail(userRequestDto.getCorreoElectronico());
        UserEntity usuarioActualizado = userRepository.save(usuario);
        return userMapper.toUserResponseDto(usuarioActualizado);
    }

    public UserResponseDto saveUser(UserRequestDto usuario) {
        UserEntity usuarioCreado = userRepository.save(this.userMapper.fromUserRequestDto(usuario));
        return this.userMapper.toUserResponseDto(usuarioCreado);
    }

    public void deleteUserById(String id) {
        userRepository.findById(id);
        userRepository.deleteById(id);
    }

    public Optional<UserEntity> getUserById(String id) {
        return Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new MissingFormatArgumentException("Usuario no encontrado con ID: " + id)));
    }

}
