package com.devity.backend.domain.exceptions.handlers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.stream.Collectors;


@ControllerAdvice
public class NotValidArgumentExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<HashMap<String,Object>> notArgumentHandler(MethodArgumentNotValidException e){
        HashMap<String, Object> response = new HashMap<>();
        response.put("errores", e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList()));
        return ResponseEntity.status(e.getStatusCode()).body(response);
    }
}
