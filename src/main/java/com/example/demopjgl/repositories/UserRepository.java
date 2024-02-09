package com.example.demopjgl.repositories;

import com.example.demopjgl.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    // Métodos para buscar usuarios por nombre y correo electrónico
    UserEntity findByNombre(String nombre);
    UserEntity findByEmail(String email);
}
