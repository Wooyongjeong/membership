package com.kakaopay.membership.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponseDto {
    private String code;
    private String message;
}
