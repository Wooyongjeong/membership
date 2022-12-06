package com.kakaopay.membership.exception.advice;

import com.kakaopay.membership.exception.dto.ErrorResponseDto;
import com.kakaopay.membership.exception.NoSuchBarcodeException;
import com.kakaopay.membership.exception.NoSuchStoreException;
import com.kakaopay.membership.exception.NotEnoughPointException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchBarcodeException.class)
    public ErrorResponseDto noSuchBarcodeExHandle(NoSuchBarcodeException e) {
        return new ErrorResponseDto("NOT_FOUND", e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchStoreException.class)
    public ErrorResponseDto noSuchStoreExHandle(NoSuchStoreException e) {
        return new ErrorResponseDto("NOT_FOUND", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotEnoughPointException.class)
    public ErrorResponseDto notEnoughPointExHandle(NotEnoughPointException e) {
        return new ErrorResponseDto("BAD_REQUEST", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponseDto illegalArgumentExHandle(IllegalArgumentException e) {
        return new ErrorResponseDto("BAD_REQUEST", e.getMessage());
    }
}
