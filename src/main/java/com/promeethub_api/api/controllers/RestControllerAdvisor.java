package com.promeethub_api.api.controllers;

import com.promeethub_api.api.models.dtos.ErrorDTO;
import com.promeethub_api.businessLayer.exceptions.EntityAlreadyExistsException;
import com.promeethub_api.businessLayer.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestControllerAdvisor {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handle(EntityNotFoundException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .status(HttpStatus.NOT_FOUND)
                                .message(ex.getMessage())
                                .requestMadeAt(LocalDateTime.now())
                                .URI(req.getRequestURI())
                                .build()
                );
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handle(EntityAlreadyExistsException ex, HttpServletRequest req){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(
                        ErrorDTO.builder()
                                .status(HttpStatus.CONFLICT)
                                .message(ex.getMessage())
                                .requestMadeAt(LocalDateTime.now())
                                .URI(req.getRequestURI())
                                .build()
                );
    }
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(ChangeSetPersister.NotFoundException exception, HttpServletRequest req){

        ErrorDTO error = ErrorDTO.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .requestMadeAt(LocalDateTime.now())
                .URI(req.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handle(RuntimeException ex, HttpServletRequest req){
        return ResponseEntity.badRequest().body(
                ErrorDTO.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .message(ex.getMessage())
                        .requestMadeAt(LocalDateTime.now())
                        .URI(req.getRequestURI())
                        .build()
        );
    }
}
