package com.example.demopjgl.services;

import com.example.demopjgl.dtos.requests.UsuarioRequestDto;
import com.example.demopjgl.dtos.responses.UsuarioResponseDto;
import com.example.demopjgl.entities.UsuarioEntity;
import com.example.demopjgl.mappers.UsuarioMapper;
import com.example.demopjgl.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingFormatArgumentException;
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
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarioMapper.usuarioListToUsuarioResponseDtoList(usuarios);
    }

    public UsuarioResponseDto actualizarUsuario(UsuarioRequestDto usuarioRequestDto, String id) throws Exception {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new Exception("Usuario no encontrado con ID: " + id));
        usuario.setNombre(usuarioRequestDto.getNombreUsuario());
        usuario.setEmail(usuarioRequestDto.getCorreoElectronico());
        UsuarioEntity usuarioActualizado = usuarioRepository.save(usuario);
        return usuarioMapper.toUsuarioResponseDto(usuarioActualizado);
    }

    public UsuarioResponseDto guardarUsuario(UsuarioRequestDto usuario) {
        UsuarioEntity usuarioCreado = usuarioRepository.save(this.usuarioMapper.fromUsuarioRequestDto(usuario));
        return this.usuarioMapper.toUsuarioResponseDto(usuarioCreado);
    }

    public List<UsuarioEntity> guardarUsuarios(List<UsuarioEntity> usuarios) {
        return usuarioRepository.saveAll(usuarios);
    }

    public void eliminarUsuarioPorId(String id) {
        usuarioRepository.findById(id);
        usuarioRepository.deleteById(id);
    }

    public Optional<UsuarioEntity> obtenerUsuarioPorId(String id) {
        return Optional.ofNullable(usuarioRepository.findById(id)
                .orElseThrow(() -> new MissingFormatArgumentException("Usuario no encontrado con ID: " + id)));
    }

}
