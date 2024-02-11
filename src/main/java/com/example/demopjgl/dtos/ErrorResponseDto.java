package com.example.demopjgl.dtos;

import com.example.demopjgl.models.ErrorModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * This class holds a list of {@code ErrorModel} that describe the error raised on rejected validation
 * @author ROUSSI Abdelghani
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    private List<ErrorModel> errorMessage;

}
