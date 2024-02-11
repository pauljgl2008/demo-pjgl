package com.example.demopjgl.dtos.responses;

import com.example.demopjgl.models.ErrorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

    private int status;

    private String error;

    private String message;

    private List<ErrorModel> errors;

}

