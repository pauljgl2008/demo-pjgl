package com.example.demopjgl.repositories;

import com.example.demopjgl.entities.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {
    // Métodos para buscar usuarios por nombre y correo electrónico
    UsuarioEntity findByNombre(String nombre);
    UsuarioEntity findByEmail(String email);
}
