package com.example.demopjgl.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel {

    private String field;

    private Object rejectedValue;

    private String message;

}

