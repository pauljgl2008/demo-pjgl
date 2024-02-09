package com.example.demopjgl.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class ErrorResponseDto {

    private int status;

    private String error;

    private String message;

    private List<ErrorModel> errors;

}

