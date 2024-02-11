package com.example.demopjgl.controllers;


import com.example.demopjgl.config.UsersConfiguration;
import com.example.demopjgl.dtos.requests.UserRequestDto;
import com.example.demopjgl.dtos.responses.UserResponseDto;
import com.example.demopjgl.entities.UserEntity;
import com.example.demopjgl.models.UsersProperties;
import com.example.demopjgl.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserService userService;

    private UsersConfiguration usersConfig;

    public UserController(UserService userService, UsersConfiguration usersConfig) {
        this.userService = userService;
        this.usersConfig = usersConfig;
    }

    @Operation(description = "Devuelve todos los users", summary = "Return 204 if no data found")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> list() {
        List<UserResponseDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> get(@PathVariable String id) {
        Optional<UserEntity> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/local")
    public ResponseEntity<String> getPropertiesLocal() throws JsonProcessingException {
        ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
        UsersProperties usersProperties = new UsersProperties(usersConfig.getSpringDataMongodbUri());
        String jsonString = owj.writeValueAsString(usersProperties);
        return ResponseEntity.ok(jsonString);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> put(
            @PathVariable String id,
            @RequestBody UserRequestDto userRequestDto) {
        try {
            UserResponseDto userUpdated = userService.updateUser(userRequestDto, id);
            return ResponseEntity.ok(userUpdated);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data. Please check your request body.",
                    content = @Content)}
    )
    @PostMapping
    public ResponseEntity<UserResponseDto> post(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userCreated = userService.saveUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
