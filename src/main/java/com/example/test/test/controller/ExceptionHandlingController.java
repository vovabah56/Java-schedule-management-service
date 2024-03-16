package com.example.test.test.controller;

import com.example.test.test.DTO.RequestError;
import com.example.test.test.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
@Slf4j
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RequestError> handleNotFoundException(HttpServletRequest request,
                                                                NotFoundException exception
    ) {
        RequestError error = new RequestError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "Некорректные входные данные",
                Stream.of(exception.getMessage()).collect(Collectors.toList())
        );


        return new ResponseEntity<>(error, error.getHttpStatus());
    }

}
