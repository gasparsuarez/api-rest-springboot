package com.devity.backend.domain.exceptions.handlers;

import com.devity.backend.domain.exceptions.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<HashMap<String,Object>> exceptionHandler(CustomException e){
        HashMap<String, Object> response = new HashMap<>();
        response.put("message",e.getMessage());
        response.put("status_code",e.getHttpStatus().value());
        return ResponseEntity.status(e.getHttpStatus().value()).body(response);
    }
}
