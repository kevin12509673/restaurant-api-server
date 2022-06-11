package com.example.restaurantPlatform.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.restaurantPlatform.utils.ErrorResponse;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(value = { MethodArgumentNotValidException.class })
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    List<String> errors = new ArrayList<>();
    e.getAllErrors().forEach((error) -> {
      errors.add(error.getDefaultMessage());
    });

    String errorString = String.join(", ", errors);

    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setMessage(errorString);

    return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
