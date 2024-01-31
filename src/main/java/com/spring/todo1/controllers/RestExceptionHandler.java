package com.spring.todo1.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)

public class RestExceptionHandler  {

        @Primary
        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<String> handleAlreadyExistsException(NoResourceFoundException ex) {
            var errorResponse = "ddkjd";//ErrorResponse.create(ex.getErrorResponse().getSource(), "already exists");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }


}

