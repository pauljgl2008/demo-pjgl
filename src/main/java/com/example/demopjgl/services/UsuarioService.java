package com.example.demopjgl.services;

import com.example.demopjgl.dtos.requests.UsuarioRequestDto;
import com.example.demopjgl.dtos.responses.UsuarioResponseDto;
import com.example.demopjgl.entities.UsuarioEntity;
import com.example.demopjgl.mappers.UsuarioMapper;
import com.example.demopjgl.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public List<UsuarioResponseDto> obtenerTodosUsuarios() {
        return usuarioMapper.usuarioListToUsuarioResponseDtoList(usuarioRepository.findAll());
    }

    public Optional<UsuarioEntity> obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioResponseDto actualizarUsuario(UsuarioRequestDto usuarioRequestDto, String id) {
        Optional<UsuarioEntity> usuarioExists = usuarioRepository.findById(id);
        if (usuarioExists.isPresent()){
            usuarioExists.get().setNombre(usuarioRequestDto.getNombreUsuario());
            usuarioExists.get().setEmail(usuarioRequestDto.getCorreoElectronico());
        }
        UsuarioResponseDto usuarioDto =  usuarioMapper.toUsuarioResponseDto(usuarioRepository.save(usuarioExists.get()));
        return usuarioDto;
    }

    public UsuarioEntity guardarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioEntity> guardarUsuarios(List<UsuarioEntity> usuarios) {
        return usuarioRepository.saveAll(usuarios);
    }

    public void eliminarUsuarioPorId(String id) {
        usuarioRepository.deleteById(id);
    }

    // Agrega métodos adicionales según sea necesario
}
