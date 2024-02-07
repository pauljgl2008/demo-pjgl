package com.example.demopjgl.services;

import com.example.demopjgl.dtos.UsuarioRequestDto;
import com.example.demopjgl.entities.UsuarioEntity;
import com.example.demopjgl.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioEntity> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioEntity actualizarUsuario(UsuarioRequestDto usuarioRequestDto, String id) {
        Optional<UsuarioEntity> usuarioExists = usuarioRepository.findById(id);
        if (usuarioExists.isPresent()){
            usuarioExists.get().setNombre(usuarioRequestDto.getNombre());
            usuarioExists.get().setEmail(usuarioRequestDto.getEmail());
        }
        return usuarioRepository.save(usuarioExists.get());
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
