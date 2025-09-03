
package com.Estudo.Tasklist.exceptions;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Estudo.Tasklist.dtos.responses.ApiError;
import com.Estudo.Tasklist.dtos.responses.ApiResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidJwtException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidJwt(InvalidJwtException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", Instant.now().toString());
        body.put("status", HttpStatus.UNAUTHORIZED.value());
        body.put("error", "Invalid Token");
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }

    public ResponseEntity<ApiResponse<List<ApiError>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<ApiError> erros = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ApiError(error.getField(), error.getDefaultMessage()))
                .toList();

        ApiResponse<List<ApiError>> response = new ApiResponse<>();
        response.setStatus("error");
        response.setData(erros);
        response.setMessage("Falha na validação dos dados");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<List<ApiError>>> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiError erro = new ApiError("creatorId", ex.getMessage());

        ApiResponse<List<ApiError>> response = new ApiResponse<>();
        response.setStatus("error");
        response.setData(Collections.singletonList(erro));
        response.setMessage("Recurso não encontrado");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

     @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<List<ApiError>>> handleConstraintViolation(ConstraintViolationException ex) {
        List<ApiError> erros = ex.getConstraintViolations().stream()
                .map(violation -> new ApiError(
                        violation.getPropertyPath().toString(),
                        violation.getMessage()
                ))
                .toList();

        ApiResponse<List<ApiError>> response = new ApiResponse<>();
        response.setStatus("error");
        response.setData(erros);
        response.setMessage("Falha na validação de dados");

        return ResponseEntity.badRequest().body(response);
    }

}
