package com.D7.myPet.webRest.exceptions;

import com.D7.myPet.service.exeption.BusinessExeption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResouceExceptionHandler {
    @ExceptionHandler(BusinessExeption.class)
    public ResponseEntity<StandardError> resouceBusiness(BusinessExeption e, HttpServletRequest request){
        String error = "business rule error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),status.value(), error,e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
