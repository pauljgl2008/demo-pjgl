package com.example.demopjgl;

import com.example.demopjgl.dtos.responses.ErrorModel;
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
